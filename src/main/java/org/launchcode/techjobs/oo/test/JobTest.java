package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.beans.JavaBean;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job3 instanceof Job);
        assertEquals("Product tester", job3.getName());
        assertTrue(job3.getEmployer() instanceof Employer);
        assertEquals("ACME", job3.getEmployer().toString());
        assertTrue(job3.getLocation() instanceof Location);
        assertEquals("Desert", job3.getLocation().toString());
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job3.getPositionType().toString());
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job3.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Web developer", new Employer("Creative Solutions"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        Job job5 = new Job("Web developer", new Employer("Creative Solutions"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job6 = new Job("Web developer", new Employer("Creative Solutions"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        assertEquals('\n', job6.toString().charAt(0));
        assertEquals('\n', job6.toString().charAt(job6.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job7 = new Job("Web developer", new Employer("American Tech"), new Location("Chicago"), new PositionType("Back-end developer"), new CoreCompetency("Java"));
        String expected = "\nID: 1" +
                "\nName: Web developer" +
                "\nEmployer: American Tech" +
                "\nLocation: Chicago" +
                "\nPosition Type: Back-end developer" +
                "\nCore Competency: Java\n";
        String actual = job7.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job8 = new Job("Web developer", new Employer("WTF Technology"), new Location("BFE"), new PositionType("Front-end developer"), new CoreCompetency(""));
        String expected = "\nID: 1" +
                "\nName: Web developer" +
                "\nEmployer: WTF Technology" +
                "\nLocation: BFE" +
                "\nPosition Type: Front-end developer" +
                "\nCore Competency: Data not available\n";
        String actual = job8.toString();
        assertEquals(expected, actual);

    }

}

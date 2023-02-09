package org.launchcode.techjobs.oo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

import static java.lang.System.in;
import static java.util.Objects.isNull;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;


    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }


    @Override
    public String toString() {
        if(!(name.isEmpty() && employer.getValue().isEmpty() && location.getValue().isEmpty() && positionType.getValue().isEmpty() && coreCompetency.getValue().isEmpty())) {
            return "\nID: " + this.getId() +
                "\nName: " + this.getName() +
                "\nEmployer: " + this.getEmployer() +
                "\nLocation: " + this.getLocation() +
                "\nPosition Type: " + this.getPositionType() +
                "\nCore Competency: " + this.getCoreCompetency() +
                "\n";
        } else {
            return "OOPS! This job does not seem to exist.";
        }

    }


    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}

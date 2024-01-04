package com.ecl.ehrm.models;

public enum EmploymentStatus {

    ENROLLED("Still Working"),

    FIRED("No Longer Working");

    public final String description;


    EmploymentStatus(String description) {
        this.description = description;
    }
}

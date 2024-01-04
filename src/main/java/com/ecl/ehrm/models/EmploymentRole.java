package com.ecl.ehrm.models;

public enum EmploymentRole {

    HR("Human Resources"),

    SOFTWAREDEVELOPER("Develops software"),


    SALES("Sells");

    public final String description;

    private EmploymentRole( String description){
        this.description = description;

    }
}

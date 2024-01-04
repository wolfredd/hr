package com.ecl.ehrm.models;

public enum LeaveTypes {

    ANNUAL("LEAVE EVERY EMPLOYEE IS ENTITLED TO"),

    SICK("LEAVE EVERY EMPLOYEE IS ENTITLED TO"),


    MATERNITY("LEAVE FOR NEW OR SOON TO BE MOTHERS");

    public final String description;

    private LeaveTypes( String description){
        this.description = description;

    }
}

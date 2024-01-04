package com.ecl.ehrm.models;

public enum LeaveStatus {

    PENDING("Pending Review"),

    ACCEPTED("Leave Has Been Accepted"),


    REJECTED("Leave Has Been Rejected");

    public final String description;

    private LeaveStatus( String description){
        this.description = description;

    }
}

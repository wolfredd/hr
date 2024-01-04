package com.ecl.ehrm.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {

    @Id
    @GeneratedValue
    public Integer id;
    public String fullName;
    public Date dateOfBirth;
    public String gender;
    public int phoneNumber;
    public String email;
    public String address;
    public String employmentType;
    @Enumerated(EnumType.STRING)
    public EmploymentStatus employmentStatus;
    @Enumerated(EnumType.STRING)
    public EmploymentRole employmentRole;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    public Department department;


//    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
//        this.employeeDetails = employeeDetails;
//        employeeDetails.setEmployee(this); // Set the UserProfile's user reference
//    }


    //    public Integer createdBy;
//    public Integer modifiedBY;
//    public DateTimeLiteralExpression.DateTime createdAt;
//    public DateTimeLiteralExpression.DateTime modifiedAt;

}

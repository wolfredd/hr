package com.ecl.ehrm.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity
@Table(name = "leaverequest")
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequest {

    @Id
    @GeneratedValue
    public Integer id;
    public Date startDate;
    public Date endDate;
    @Enumerated(EnumType.STRING)
    public LeaveTypes leaveType;
    @Enumerated(EnumType.STRING)
    public LeaveStatus leaveStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    public Employee employee;




//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id")
//    public Employee employee;
}

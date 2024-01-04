package com.ecl.ehrm.services;

import com.ecl.ehrm.models.*;
import com.ecl.ehrm.repositories.EmployeeRepository;
import com.ecl.ehrm.repositories.LeaveRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeaveRequestServiceTest {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @MockBean
    private LeaveRepository leaveRepository;


    @Test
    public void askForLeave(){

        LeaveRequest leave = new LeaveRequest();

        when(leaveRepository.save(leave)).thenReturn(leave);

        assertEquals(leave, leaveRequestService.saveLeave(leave));
    }

    @Test
    public void acceptLeave(){

        LeaveRequest leave = LeaveRequest.builder().leaveStatus(LeaveStatus.PENDING).leaveType(LeaveTypes.ANNUAL).build();
        LeaveReview leaveReview = LeaveReview.builder().leaveId(1).leaveStatus(LeaveStatus.ACCEPTED).build();

        when(leaveRepository.findById(leaveReview.getLeaveId())).thenReturn(Optional.ofNullable(leave));
        leaveRequestService.leaveAccepted(leaveReview);

        assertEquals(LeaveStatus.ACCEPTED, leave.getLeaveStatus());

    }

}
package com.ecl.ehrm.controllers;

import com.ecl.ehrm.dtos.AllLeaveResponse;
import com.ecl.ehrm.dtos.MessageResponse;
import com.ecl.ehrm.dtos.OneLeaveResponse;
import com.ecl.ehrm.models.LeaveRequest;
import com.ecl.ehrm.models.LeaveReview;
import com.ecl.ehrm.services.LeaveRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leave")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class LeaveController{

    public final LeaveRequestService leaveRequestService;

    @PostMapping("/register")
    public MessageResponse registerLeaveRequest(@RequestBody LeaveRequest leaveRequest){

        MessageResponse messageResponse = leaveRequestService.registerLeave(leaveRequest);

        return messageResponse;
    }

    @PostMapping("/accepted")
    public MessageResponse acceptLeaveRequest(@RequestBody LeaveReview leaveReview){

        MessageResponse messageResponse = leaveRequestService.acceptLeave(leaveReview);
        return messageResponse;
    }

    @PostMapping("/getOneLeave/{leaveRequestId}")
    public OneLeaveResponse getOneLeave(@PathVariable("leaveRequestId") Integer leaveRequestId){

        OneLeaveResponse oneLeaveResponse = leaveRequestService.findLeaveRequest(leaveRequestId);
        return oneLeaveResponse;
    }

    @PostMapping("/getAllLeaves")
    public AllLeaveResponse getAllLeaveRequest(){

        AllLeaveResponse allLeaveResponse = leaveRequestService.findAllLeaveRequests();
        return allLeaveResponse;
    }


    @PostMapping("/getAllLeavesByEmployeeId/{employeeId}")
    public AllLeaveResponse getAllLeaveRequestByEmployeeId(@PathVariable("employeeId") Integer employeeId){

        AllLeaveResponse allLeaveResponse = leaveRequestService.findAllLeavesByEmployeeId(employeeId);
        return allLeaveResponse;
    }

    @PostMapping("/updateLeaveRequest")
    public MessageResponse updateLeaveRequest(@RequestBody LeaveRequest leaveRequest){

        MessageResponse messageResponse = leaveRequestService.updateLeave(leaveRequest);

        return messageResponse;
    }


    @PostMapping("/delete/{leaveRequestId}")
    public MessageResponse deleteLeave(@PathVariable("leaveRequestId") Integer leaveRequestId){
        MessageResponse messageResponse = leaveRequestService.deleteLeaveRequest(leaveRequestId);
        return messageResponse;
    }



}


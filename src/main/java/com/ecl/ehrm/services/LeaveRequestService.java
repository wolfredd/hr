package com.ecl.ehrm.services;

import com.ecl.ehrm.dtos.AllLeaveResponse;
import com.ecl.ehrm.dtos.MessageResponse;
import com.ecl.ehrm.dtos.OneLeaveResponse;
import com.ecl.ehrm.models.LeaveRequest;
import com.ecl.ehrm.models.LeaveReview;
import com.ecl.ehrm.models.LeaveStatus;
import com.ecl.ehrm.repositories.LeaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LeaveRequestService {

    public final LeaveRepository leaveRepository;

    public MessageResponse registerLeave(LeaveRequest leaveRequest){

        leaveRequest.setLeaveStatus(LeaveStatus.PENDING);
        leaveRepository.save(leaveRequest);

        MessageResponse messageResponse = new MessageResponse("000", "Leave registered successfully");
        return messageResponse;
    }

    public MessageResponse acceptLeave(LeaveReview leaveReview){

        LeaveRequest pendingLeave = leaveRepository.findById(leaveReview.getLeaveId()).orElseThrow();

        pendingLeave.setLeaveStatus(leaveReview.getLeaveStatus());

//        LeaveRequest pendingLeaveRequest = leaveRepository.findById(leaveRequestID).orElseThrow();
//        pendingLeaveRequest.setStatus("ACCEPTED");
        leaveRepository.save(pendingLeave);

        MessageResponse messageResponse = new MessageResponse("000", "Leave has been accepted");
        return messageResponse;
    }

    public OneLeaveResponse findLeaveRequest(Integer leaveRequestId){

        OneLeaveResponse oneLeaveResponse = new OneLeaveResponse("000", "Leave Requests Found", leaveRepository.findById(leaveRequestId).orElseThrow());
        return oneLeaveResponse;

    }

    public AllLeaveResponse findAllLeaveRequests(){

        AllLeaveResponse allLeaveResponse = new AllLeaveResponse("000", "All Leave Requests Found", leaveRepository.findAll());
        return allLeaveResponse;
    }

    public AllLeaveResponse findAllLeavesByEmployeeId(Integer employeeId){

        AllLeaveResponse allLeaveResponse = new AllLeaveResponse("000", "All Leave Requests By Employee ID Found", leaveRepository.findAllByEmployeeId(employeeId));
        return allLeaveResponse;

    }

    public MessageResponse updateLeave(LeaveRequest leaveRequest){

        LeaveRequest leaveRequest1 = leaveRepository.findById(leaveRequest.getId()).orElseThrow();

        if(leaveRequest1.getLeaveStatus() == LeaveStatus.PENDING){
            leaveRequest1.setEmployee(leaveRequest.getEmployee());
            leaveRequest1.setLeaveStatus(leaveRequest.getLeaveStatus());
            leaveRequest1.setLeaveType(leaveRequest.getLeaveType());
            leaveRequest1.setStartDate(leaveRequest.getStartDate());
            leaveRequest1.setEndDate(leaveRequest.getEndDate());

            leaveRepository.save(leaveRequest1);

            MessageResponse messageResponse = new MessageResponse("000", "Leave updated successfully");

            return messageResponse;
        }
        else{
            MessageResponse messageResponse = new MessageResponse("111", "Leave not updated");

            return messageResponse;

        }

    }

    public MessageResponse deleteLeaveRequest(Integer leaveRequestId){

        leaveRepository.deleteById(leaveRequestId);

        MessageResponse messageResponse = new MessageResponse("000", "Leave deleted");

        return messageResponse;
    }



    public LeaveRequest saveLeave(LeaveRequest leaveRequest){

        leaveRequest.setLeaveStatus(LeaveStatus.PENDING);
        return leaveRepository.save(leaveRequest);

    }

    public LeaveRequest leaveAccepted(LeaveReview leaveReview){

        LeaveRequest pendingLeave = leaveRepository.findById(leaveReview.getLeaveId()).orElseThrow();

        pendingLeave.setLeaveStatus(leaveReview.getLeaveStatus());


        return leaveRepository.save(pendingLeave);

    }

    public LeaveRequest findOneLeaveRequest(Integer leaveRequestId){

        return leaveRepository.findById(leaveRequestId).orElseThrow();
    }

    public List<LeaveRequest> findAllLeaves(){

        return leaveRepository.findAll();
    }

}

package com.ecl.ehrm.dtos;

import com.ecl.ehrm.models.Employee;
import com.ecl.ehrm.models.LeaveRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllLeaveResponse extends MessageResponse {

    private List<LeaveRequest> allLeaveRequest = new ArrayList<>();

    public AllLeaveResponse(String code, String message, List<LeaveRequest> allLeaveRequest) {
        super(code, message);
        this.allLeaveRequest = allLeaveRequest;
    }
}

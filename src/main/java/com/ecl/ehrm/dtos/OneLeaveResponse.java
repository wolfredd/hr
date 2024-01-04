package com.ecl.ehrm.dtos;

import com.ecl.ehrm.models.LeaveRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneLeaveResponse extends MessageResponse{

    private LeaveRequest leave;

    public OneLeaveResponse(String code, String message, LeaveRequest leave) {
        super(code, message);
        this.leave = leave;
    }

}
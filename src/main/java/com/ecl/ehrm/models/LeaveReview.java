package com.ecl.ehrm.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LeaveReview {

    public int leaveId;
    public LeaveStatus leaveStatus;
}

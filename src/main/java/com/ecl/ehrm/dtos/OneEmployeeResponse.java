package com.ecl.ehrm.dtos;

import com.ecl.ehrm.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneEmployeeResponse extends MessageResponse{

    private Employee employee;
}

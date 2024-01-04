package com.ecl.ehrm.dtos;

import com.ecl.ehrm.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllEmployeesResponse extends MessageResponse{

    private List<Employee> listOfEmployees = new ArrayList<>();


}

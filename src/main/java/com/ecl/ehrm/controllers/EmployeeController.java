package com.ecl.ehrm.controllers;

import com.ecl.ehrm.dtos.*;
import com.ecl.ehrm.models.Employee;
import com.ecl.ehrm.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class EmployeeController {

    public final EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<EmployeeCreationResponse> registerEmployee(@RequestBody Employee employee){
        EmployeeCreationResponse employeeCreationResponse = employeeService.registerEmployee(employee);

        return ResponseEntity.ok(employeeCreationResponse);
    }

    @GetMapping("/employees")
    public ResponseEntity<AllEmployeesResponse> viewAllEmployees(){
        AllEmployeesResponse allEmployeesResponse = employeeService.viewAllEmployees();
        return ResponseEntity.ok(allEmployeesResponse);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<OneEmployeeResponse> viewOneEmployee(@PathVariable("employeeId") Integer employeeId){
        OneEmployeeResponse oneEmployeeResponse = employeeService.viewOneEmployee(employeeId);
        return ResponseEntity.ok(oneEmployeeResponse);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateEmployeeResponse> updateEmployeeName(@RequestBody Employee employee){
        UpdateEmployeeResponse updateEmployeeResponse = employeeService.updateEmployeeName(employee);
        return ResponseEntity.ok(updateEmployeeResponse);
    }


//    @PutMapping("/employee/update/{employeeId}/employmenttype/{employmenttype}")
//    public ResponseEntity<UpdateEmployeeResponse> updateEmployeeEmploymentType(@PathVariable("employeeId") Integer employeeId, @PathVariable("employmenttype") String employmenttype){
//        UpdateEmployeeResponse updateEmployeeResponse = employeeService.updateEmploymentType(employeeId, employmenttype);
//        return ResponseEntity.ok(updateEmployeeResponse);
//    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<DeleteEmployeeResponse> deleteEmployee(@PathVariable("employeeId") Integer employeeId){

        DeleteEmployeeResponse deleteEmployeeResponse = employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok(deleteEmployeeResponse);
    }

}



package com.ecl.ehrm.services;

import com.ecl.ehrm.dtos.*;
import com.ecl.ehrm.models.EmploymentStatus;
import com.ecl.ehrm.repositories.EmployeeRepository;
import com.ecl.ehrm.models.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    public  final EmployeeRepository employeeRepository;

    public EmployeeCreationResponse registerEmployee(Employee employee){

        boolean emailExists = employeeRepository.existsByEmail(employee.getEmail());
        boolean phoneExists = employeeRepository.existsByPhoneNumber(employee.getPhoneNumber());

        if (phoneExists && emailExists) {

            EmployeeCreationResponse employeeCreationResponse = new EmployeeCreationResponse();
            employeeCreationResponse.setResponseCode("111");
            employeeCreationResponse.setResponseMessage("Employee Phone Number And Email Already Exists");

            return employeeCreationResponse;

        }

        else if (emailExists){

            EmployeeCreationResponse employeeCreationResponse = new EmployeeCreationResponse();
            employeeCreationResponse.setResponseCode("111");
            employeeCreationResponse.setResponseMessage("Employee Email Already Exists");

            return employeeCreationResponse;

        } else if (phoneExists) {

            EmployeeCreationResponse employeeCreationResponse = new EmployeeCreationResponse();
            employeeCreationResponse.setResponseCode("111");
            employeeCreationResponse.setResponseMessage("Employee Phone Number Already Exists");

            return employeeCreationResponse;

        }
        else {

            employee.setEmploymentStatus(EmploymentStatus.ENROLLED);
            employeeRepository.save(employee);
            EmployeeCreationResponse employeeCreationResponse = new EmployeeCreationResponse();
            employeeCreationResponse.setResponseCode("000");
            employeeCreationResponse.setResponseMessage("Employee Registered Successfully");

            return employeeCreationResponse;

        }
    }

    public AllEmployeesResponse viewAllEmployees(){

        AllEmployeesResponse allEmployeesResponse = new AllEmployeesResponse();
        allEmployeesResponse.setResponseCode("000");
        allEmployeesResponse.setResponseMessage("All Registered Employees");
        allEmployeesResponse.setListOfEmployees(employeeRepository.findAll());

        return allEmployeesResponse;
    }

    public OneEmployeeResponse viewOneEmployee(Integer employeeId) {

        OneEmployeeResponse oneEmployeeResponse = new OneEmployeeResponse();
        oneEmployeeResponse.setResponseCode("000");
        oneEmployeeResponse.setResponseMessage("One Employee");
        oneEmployeeResponse.setEmployee(employeeRepository.findById(employeeId).orElseThrow());

        return oneEmployeeResponse;
    }

    public UpdateEmployeeResponse updateEmployeeName(Employee employee){
        Employee employee1 = employeeRepository.findEmployeeByEmail(employee.getEmail());

        employee1.setFullName(employee.getFullName());
        employee1.setDateOfBirth(employee.getDateOfBirth());
        employee1.setAddress(employee.getAddress());
        employee1.setEmploymentType(employee.getEmploymentType());
        employee1.setPhoneNumber(employee.getPhoneNumber());
        employee1.setEmail(employee.getEmail());
        employee1.setGender(employee.getGender());

        employeeRepository.save(employee1);

        UpdateEmployeeResponse updateEmployeeResponse = new UpdateEmployeeResponse();
        updateEmployeeResponse.setResponseCode("000");
        updateEmployeeResponse.setResponseMessage("Employee Updated");

        return updateEmployeeResponse;
    }



    public DeleteEmployeeResponse deleteEmployee(Integer employeeId){

        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        employee.setEmploymentStatus(EmploymentStatus.FIRED);
        employeeRepository.save(employee);

        DeleteEmployeeResponse deleteEmployeeResponse = new DeleteEmployeeResponse();

        deleteEmployeeResponse.setResponseCode("000");
        deleteEmployeeResponse.setResponseMessage("Employee Deleted");
        return deleteEmployeeResponse;
    }













    public Employee saveEmployee(Employee employee){

        employee.setEmploymentStatus(EmploymentStatus.ENROLLED);
        employeeRepository.save(employee);

        return employee;
    }

    public List<Employee> viewEmployees(){

        return employeeRepository.findAll();
    }

    public Employee findOneEmployee(Integer employeeId) {

        return employeeRepository.findById(employeeId).orElseThrow();
    }


    public Employee changeEmployeeName(Employee employee){
        Employee employee1 = employeeRepository.findEmployeeByEmail(employee.getEmail());

        employee1.setFullName(employee.getFullName());
        employee1.setDateOfBirth(employee.getDateOfBirth());
        employee1.setAddress(employee.getAddress());
        employee1.setEmploymentType(employee.getEmploymentType());
        employee1.setPhoneNumber(employee.getPhoneNumber());
        employee1.setEmail(employee.getEmail());
        employee1.setGender(employee.getGender());

        employeeRepository.save(employee1);


        return employee1;
    }


    public Employee removeEmployee(Integer employeeId){

        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        employee.setEmploymentStatus(EmploymentStatus.FIRED);
        employeeRepository.save(employee);

        return employee;
    }




}


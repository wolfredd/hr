package com.ecl.ehrm.services;

import static org.mockito.Mockito.when;
import com.ecl.ehrm.models.Employee;
import com.ecl.ehrm.models.EmploymentStatus;
import com.ecl.ehrm.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void getEmployees(){

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();
        Employee employee4 = new Employee();
        Employee employee5 = new Employee();
        Employee employee6 = new Employee();

        List<Employee> employees = new ArrayList<>(Arrays.asList(employee1, employee2, employee3, employee6, employee4, employee5));

        when(employeeRepository.findAll()).thenReturn(employees);

        assertEquals(6, employeeService.viewEmployees().size());
    }


    @Test
    public void saveEmployee(){

        Employee employee = new Employee();

        when(employeeRepository.save(employee)).thenReturn(employee);

        assertEquals(employee, employeeService.saveEmployee(employee));
    }


    @Test
    public void findOneEmployee(){

        Employee employee = new Employee();
        Integer employeeId = 1;

        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        assertEquals(employee, employeeService.findOneEmployee(employeeId));
    }


    @Test
    public void changeEmployeeName(){

        Employee oldEmployee = Employee.builder().fullName("Wilfred").email("email").gender("Male").address("Ash").build();
        Employee newEmployee = Employee.builder().fullName("John").email("email").gender("Male").address("Ash").build();

        when(employeeRepository.findEmployeeByEmail(newEmployee.getEmail())).thenReturn(oldEmployee);
        employeeService.changeEmployeeName(newEmployee);

        assertEquals("John", oldEmployee.getFullName());
    }


    @Test
    public void removeEmployee(){

        Employee employee = Employee.builder().fullName("Wilfred").email("email").gender("Male").address("Ash").build();
        when(employeeRepository.findById(1)).thenReturn(Optional.ofNullable(employee));

        employeeService.deleteEmployee(1);

        assertEquals(EmploymentStatus.FIRED, employee.getEmploymentStatus());
    }

}
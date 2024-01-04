package com.ecl.ehrm.controllers;

import com.ecl.ehrm.models.Employee;
import com.ecl.ehrm.repositories.EmployeeRepository;
import com.ecl.ehrm.services.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.annotation.security.RunAs;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
    private MockMvc mockMvc;


    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();


    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private EmployeeController employeeController;


    Employee employee1 = new Employee();
    Employee employee2 = new Employee();
    Employee employee3 = new Employee();


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void getAllEmployees() throws Exception{
        List<Employee> employees = new ArrayList<>(Arrays.asList(employee1, employee2, employee3));

        Mockito.when(employeeRepository.findAll()).thenReturn(employees);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employee/employees").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/employee/employees").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)));

    }




}
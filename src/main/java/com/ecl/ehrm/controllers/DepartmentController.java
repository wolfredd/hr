package com.ecl.ehrm.controllers;

import com.ecl.ehrm.models.Department;
import com.ecl.ehrm.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/adddepartment")
    public String addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }
}

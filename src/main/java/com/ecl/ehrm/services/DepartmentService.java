package com.ecl.ehrm.services;

import com.ecl.ehrm.models.Department;
import com.ecl.ehrm.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public String addDepartment(Department department){
        departmentRepository.save(department);
        return "department saved";
    }
}

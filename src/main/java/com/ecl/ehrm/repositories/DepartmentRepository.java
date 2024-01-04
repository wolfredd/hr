package com.ecl.ehrm.repositories;

import com.ecl.ehrm.models.Department;
import com.ecl.ehrm.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

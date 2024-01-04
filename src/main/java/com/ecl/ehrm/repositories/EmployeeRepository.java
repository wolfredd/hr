package com.ecl.ehrm.repositories;

import com.ecl.ehrm.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findEmployeeByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(int phoneNumber);

}

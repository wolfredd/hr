package com.ecl.ehrm.repositories;

import com.ecl.ehrm.models.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveRequest, Integer> {

    List<LeaveRequest> findAllByEmployeeId(Integer employeeId);
}

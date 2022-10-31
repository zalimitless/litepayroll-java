package com.payroll.e.litepayroll;

import com.payroll.e.litepayroll.DTO.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Long> {

}
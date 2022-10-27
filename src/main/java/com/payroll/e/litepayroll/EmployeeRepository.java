package com.payroll.e.litepayroll;

import com.payroll.e.litepayroll.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Long> {

}
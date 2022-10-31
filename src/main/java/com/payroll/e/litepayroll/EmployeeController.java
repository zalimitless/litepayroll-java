package com.payroll.e.litepayroll;

import java.util.ArrayList;
import java.util.List;

import com.payroll.e.litepayroll.DTO.EmployeeDTO;
import com.payroll.e.litepayroll.DTO.EmployeeBasicDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "*")
class EmployeeController {

    @Autowired
    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    //@GetMapping("/employeeinformation")
    List<EmployeeDTO> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @GetMapping("/employeetable")
    List<EmployeeBasicDTO> employeeTable() {
        List<EmployeeBasicDTO> returnList = new ArrayList<EmployeeBasicDTO>();
        all().forEach(employeeDTO -> returnList.add(employeeDTO.toBasic()));

        return returnList;
    }

    // Single item
    @CrossOrigin(origins = "*")
    @GetMapping("/employeeinformation/{id}")
    EmployeeDTO one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find employee: " + id));
    }

    @PutMapping("/addorupdateemployee")
    EmployeeDTO replaceEmployee(@RequestBody EmployeeDTO newEmployee, @PathVariable String employeeNumber) {

        try
        {
            Long.parseLong(employeeNumber);
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "employeeNumber requires to be a long value.");
        }
        return repository.findById(Long.parseLong(employeeNumber))
                .map(employee -> {
                    employee.setFirstNames(newEmployee.getFirstNames());
                    employee.setGender(newEmployee.getGender());
                    employee.setGrossSalary(newEmployee.getGrossSalary());
                    employee.setLastName(newEmployee.getLastName());
                    employee.setSalutation(newEmployee.getSalutation());
                    employee.setProfileColour(newEmployee.getProfileColour());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setEmployeeNumber(Long.parseLong(employeeNumber));
                    return repository.save(newEmployee);
                });
    }
}
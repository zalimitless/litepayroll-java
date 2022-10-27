package com.payroll.e.litepayroll;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
class EmployeeController {

    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/employeeinformation")
    List<EmployeeDTO> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/employeeinformation/newemployee")
    EmployeeDTO newEmployee(@RequestBody EmployeeDTO newEmployeeDTO) {
        return repository.save(newEmployeeDTO);
    }

    // Single item

    @GetMapping("/employeeinformation/{id}")
    EmployeeDTO one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find employee: " + id));
    }

    @PutMapping("/employeeinformation/{id}")
    EmployeeDTO replaceEmployee(@RequestBody EmployeeDTO newEmployee, @PathVariable Long employeeNumber) {

        return repository.findById(employeeNumber)
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
                    newEmployee.setEmployeeNumber(employeeNumber);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employeeinformation/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
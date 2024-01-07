package com.srijanmukherjee.employeemanagement.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> fetchAll() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee fetch(@PathVariable UUID id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public Employee update(@PathVariable UUID id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
    }
}

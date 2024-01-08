package com.srijanmukherjee.employeemanagement.service;

import com.srijanmukherjee.employeemanagement.repository.EmployeeRepository;
import com.srijanmukherjee.employeemanagement.exception.EmployeeNotFoundException;
import com.srijanmukherjee.employeemanagement.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Employee getEmployee(UUID id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(UUID id, Employee employee) {
        // TODO: implement partial update, right now user has to send the entire Employee object
        Employee emp = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmail(employee.getEmail());
        emp.setPhoneNumber(employee.getPhoneNumber());
        emp.setDateOfJoin(employee.getDateOfJoin());
        emp.setAddress(employee.getAddress());
        return employeeRepository.save(emp);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
}

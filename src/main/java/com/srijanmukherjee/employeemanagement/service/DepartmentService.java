package com.srijanmukherjee.employeemanagement.service;

import com.srijanmukherjee.employeemanagement.repository.DepartmentRepository;
import com.srijanmukherjee.employeemanagement.exception.DepartmentNotFoundException;
import com.srijanmukherjee.employeemanagement.entity.Employee;
import com.srijanmukherjee.employeemanagement.entity.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeService employeeService;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeService employeeService) {
        this.departmentRepository = departmentRepository;
        this.employeeService = employeeService;
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    public Department addDepartment(Department department) {
        department.setId(null);
        return departmentRepository.save(department);
    }

    public Department getDepartment(UUID id) {
        return departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
    }

    public Department updateDepartment(UUID id, Department department) {
        Department dept = departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
        dept.setName(department.getName());
        return departmentRepository.save(dept);
    }

    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }

    public Department addEmployeeToDepartment(UUID id, UUID empId) {
        Employee emp = employeeService.getEmployee(empId);
        Department dept = departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
        emp.setDepartment(dept);
        dept.getEmployees().add(emp);
        // This updates employee table, because it's the owning side containing the foreign key
        return departmentRepository.save(dept);
    }
}

package com.srijanmukherjee.employeemanagement.department;

import com.srijanmukherjee.employeemanagement.department.exception.DepartmentNotFoundException;
import com.srijanmukherjee.employeemanagement.employee.Employee;
import com.srijanmukherjee.employeemanagement.employee.EmployeeRepository;
import com.srijanmukherjee.employeemanagement.employee.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
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

    public Employee addEmployeeToDepartment(UUID id, UUID empId) {
        Employee emp = employeeRepository.findById(empId).orElseThrow(EmployeeNotFoundException::new);
        Department dept = departmentRepository.findById(id).orElseThrow(DepartmentNotFoundException::new);
        emp.setDepartment(dept);
        return employeeRepository.save(emp);
    }
}

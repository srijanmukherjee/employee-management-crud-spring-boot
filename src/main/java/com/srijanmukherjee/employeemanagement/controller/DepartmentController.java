package com.srijanmukherjee.employeemanagement.controller;

import com.srijanmukherjee.employeemanagement.service.DepartmentService;
import com.srijanmukherjee.employeemanagement.entity.Department;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<Department> fetchAll() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department fetch(@PathVariable UUID id) {
        return departmentService.getDepartment(id);
    }

    @PostMapping("/departments")
    public Department create(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @PutMapping("/departments/{id}")
    public Department update(@PathVariable UUID id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/departments/{id}")
    public void delete(@PathVariable UUID id) {
        departmentService.deleteDepartment(id);
    }

    @PostMapping("/departments/{id}/add/{empId}")
    public Department addEmployeeToDepartment(@PathVariable UUID id, @PathVariable UUID empId) {
        return departmentService.addEmployeeToDepartment(id, empId);
    }
}

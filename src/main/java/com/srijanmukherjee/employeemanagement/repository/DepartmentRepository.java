package com.srijanmukherjee.employeemanagement.repository;

import com.srijanmukherjee.employeemanagement.entity.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DepartmentRepository extends CrudRepository<Department, UUID> {
}

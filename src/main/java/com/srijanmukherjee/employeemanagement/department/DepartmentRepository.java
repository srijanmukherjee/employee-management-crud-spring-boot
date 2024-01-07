package com.srijanmukherjee.employeemanagement.department;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DepartmentRepository extends CrudRepository<Department, UUID> {
}

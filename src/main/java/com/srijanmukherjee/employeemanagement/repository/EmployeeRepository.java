package com.srijanmukherjee.employeemanagement.repository;

import com.srijanmukherjee.employeemanagement.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<Employee, UUID> {
}

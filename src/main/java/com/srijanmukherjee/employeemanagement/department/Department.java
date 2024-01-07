package com.srijanmukherjee.employeemanagement.department;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.srijanmukherjee.employeemanagement.employee.Employee;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "department", targetEntity = Employee.class, cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("department")
    private Set<Employee> employees = new HashSet<>();

    public Department() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee emp) {
        if (employees == null) {
            employees = new HashSet<>();
        }
        employees.add(emp);
    }
}

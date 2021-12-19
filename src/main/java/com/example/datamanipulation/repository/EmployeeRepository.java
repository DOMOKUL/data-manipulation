package com.example.datamanipulation.repository;

import com.example.datamanipulation.domain.Employee;
import com.example.datamanipulation.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Employee findByLogin(String login);
    Employee findEmployeeByPasswordAndLogin(String password, String login);
}

package com.example.datamanipulation.service;

import com.example.datamanipulation.domain.Employee;
import com.example.datamanipulation.domain.Roles;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    Employee saveEmployee(Employee employee) throws Exception;

    Employee getEmployeeById(UUID id);

    List<Employee> getAllEmployees();

    void deleteEmployeeById(UUID id);

    List<Employee> saveAllEmployees(List<Employee> employees);

    Employee loadEmployeeByLogin(String login);

    List<Employee> getAllEmployeeWithManagerRole(Roles roles);

    Employee getByPasswordAndLogin(String login, String password);
}

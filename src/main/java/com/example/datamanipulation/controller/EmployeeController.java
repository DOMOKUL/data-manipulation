package com.example.datamanipulation.controller;

import com.example.datamanipulation.domain.Employee;
import com.example.datamanipulation.domain.Roles;
import com.example.datamanipulation.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
@RequestMapping("api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) throws Exception {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id){
        return employeeService.getEmployeeById(UUID.fromString(id));
    }

    @GetMapping
    public List<Employee> getEmployeeWithRoleManagerById(@RequestParam String role){
        return employeeService.getAllEmployeeWithManagerRole(Roles.valueOf(role));
    }


}

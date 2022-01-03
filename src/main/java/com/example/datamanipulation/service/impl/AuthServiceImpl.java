package com.example.datamanipulation.service.impl;

import com.example.datamanipulation.domain.Employee;
import com.example.datamanipulation.dto.AuthEmployeeDto;
import com.example.datamanipulation.service.AuthService;
import com.example.datamanipulation.service.EmployeeService;
import com.example.datamanipulation.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final EmployeeService employeeService;
    private final PasswordService passwordService;
    private Employee employee;

    @Override
    public UUID authorizeEmployee(AuthEmployeeDto authEmployeeDto) throws Exception {

        return employeeService.getByPasswordAndLogin(authEmployeeDto.getLogin(), passwordService.decode(authEmployeeDto.getPassword())).getId();
    }

}

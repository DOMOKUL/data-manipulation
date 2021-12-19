package com.example.datamanipulation.service.impl;

import com.example.datamanipulation.domain.Employee;
import com.example.datamanipulation.dto.AuthEmployeeDto;
import com.example.datamanipulation.service.AuthService;
import com.example.datamanipulation.service.EmployeeService;
import com.example.datamanipulation.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final EmployeeService employeeService;
    private final PasswordService passwordService;
    private Employee employee;
    String PASSWORD = "this is a password";


    @Override
    public UUID authorizeEmployee(AuthEmployeeDto authEmployeeDto) throws Exception {

        return employeeService.getByPasswordAndLogin(authEmployeeDto.getLogin(), passwordService.decode(authEmployeeDto.getPassword())).getId();
    }

}

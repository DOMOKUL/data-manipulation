package com.example.datamanipulation.dto;

import com.example.datamanipulation.domain.Role;

import java.util.Set;

public class EmployeeDto {

    private Integer roleId;
    private String phone;
    private String email;
    private String login;
    private String password;
    private String passwordConfirm;
    private Set<Role> roles;
}

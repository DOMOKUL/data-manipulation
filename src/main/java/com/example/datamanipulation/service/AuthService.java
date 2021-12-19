package com.example.datamanipulation.service;

import com.example.datamanipulation.dto.AuthEmployeeDto;

import java.nio.charset.CharacterCodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public interface AuthService {

    UUID authorizeEmployee(AuthEmployeeDto authEmployeeDto) throws NoSuchAlgorithmException, CharacterCodingException, Exception;
}

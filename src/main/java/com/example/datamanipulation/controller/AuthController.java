package com.example.datamanipulation.controller;

import com.example.datamanipulation.dto.AuthEmployeeDto;
import com.example.datamanipulation.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public UUID authEmployee(@RequestBody AuthEmployeeDto authEmployeeDto) throws Exception {
        return authService.authorizeEmployee(authEmployeeDto);
    }

}

package com.ian.userapi.controller;

import com.ian.userapi.dto.LoginRequestDTO;
import com.ian.userapi.entity.User;
import com.ian.userapi.security.JwtUtil;
import com.ian.userapi.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO dto) {
        User user = authService.authenticate(dto);
        return JwtUtil.generateToken(user.getEmail());
    }
}
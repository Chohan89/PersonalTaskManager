package com.ptm.personaltaskmanager.controller;

import com.ptm.personaltaskmanager.dto.LoginRequest;
import com.ptm.personaltaskmanager.dto.LoginResponse;
import com.ptm.personaltaskmanager.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    
	//GetMapping will expose username and pass via url so use PostMapping instead
	//Spring will send response entity which is a session cookie token for auth.
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
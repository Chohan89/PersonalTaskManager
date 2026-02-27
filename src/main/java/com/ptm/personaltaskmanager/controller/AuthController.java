package com.ptm.personaltaskmanager.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptm.personaltaskmanager.dto.CreateAccountRequest;
import com.ptm.personaltaskmanager.dto.CreateAccountResponse;
import com.ptm.personaltaskmanager.dto.LoginRequest;
import com.ptm.personaltaskmanager.dto.LoginResponse;
import com.ptm.personaltaskmanager.service.AuthService;
import com.ptm.personaltaskmanager.service.CreateAccountService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final CreateAccountService createAccountService;

    public AuthController(AuthService authService, CreateAccountService createAccountService) {
        this.authService = authService;
        this.createAccountService = createAccountService;
    }
    
	//GetMapping will expose username and pass via url so use PostMapping instead
	//Spring will send response entity which is a session cookie token for auth.
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
    
    @PostMapping("/createaccount")
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request) {
    	return createAccountService.createUser(request);
    }
}
package com.ptm.personaltaskmanager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ptm.personaltaskmanager.database.AuthenticationRepository;
import com.ptm.personaltaskmanager.dto.LoginRequest;
import com.ptm.personaltaskmanager.dto.LoginResponse;
import com.ptm.personaltaskmanager.exception.InvalidPasswordException;
import com.ptm.personaltaskmanager.exception.UserNotFoundException;
import com.ptm.personaltaskmanager.model.Users;

@Service
public class AuthService {
	private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    private final AuthenticationRepository authenticationRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthenticationRepository authenticationRepository, PasswordEncoder passwordEncoder) {
        this.authenticationRepository = authenticationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(LoginRequest request) {
    	log.debug("AuthService.login: Starting Method");
    	log.debug("AuthService.login: Username = " + request.getUsername());
    	
        Users user = authenticationRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException(request.getUsername()));

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new InvalidPasswordException();
        }

        LoginResponse response = new LoginResponse();
        response.setMessage("Login successful");
        //response.setToken("dummy-token"); // replace with JWT later
    	log.debug("AuthService.login: Message = " + response.getMessage());

        return response;
    }

}

package com.ptm.personaltaskmanager.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ptm.personaltaskmanager.database.CreateAccountRepository;
import com.ptm.personaltaskmanager.dto.CreateAccountRequest;
import com.ptm.personaltaskmanager.dto.CreateAccountResponse;
import com.ptm.personaltaskmanager.exception.DuplicateTitleException;
import com.ptm.personaltaskmanager.model.Users;

@Service
public class CreateAccountService {

	private final CreateAccountRepository createAccountRepository;
    private final PasswordEncoder passwordEncoder;
	
	public CreateAccountService(CreateAccountRepository createAccountRepository, PasswordEncoder passwordEncoder) {
		this.createAccountRepository =  createAccountRepository;
        this.passwordEncoder = passwordEncoder;
	}
	
	public CreateAccountResponse createUser(CreateAccountRequest request) {
		
		//if username exists in db we throw exception
		createAccountRepository.findByUsername(request.getUsername())
				.ifPresent(u -> {
		            throw new DuplicateTitleException();
		        });

		Users user = new Users(); 
		user.setUsername(request.getUsername());
	    user.setPasswordHash(passwordEncoder.encode(request.getPassword()));

		CreateAccountResponse response = new CreateAccountResponse();
		response.setUsername(user.getUsername());
		response.setMessage("Login successful");
        return response;
	}
}

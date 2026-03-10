package com.ptm.personaltaskmanager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ptm.personaltaskmanager.database.CreateAccountRepository;
import com.ptm.personaltaskmanager.dto.CreateAccountRequest;
import com.ptm.personaltaskmanager.dto.CreateAccountResponse;
import com.ptm.personaltaskmanager.enums.ResponseCodes;
import com.ptm.personaltaskmanager.exception.DuplicateTitleException;
import com.ptm.personaltaskmanager.mapper.UserMapper;
import com.ptm.personaltaskmanager.model.Tasks;
import com.ptm.personaltaskmanager.model.Users;

@Service
public class CreateAccountService {

	private static final Logger log = LoggerFactory.getLogger(CreateAccountService.class);

	private final CreateAccountRepository createAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
	
	public CreateAccountService(CreateAccountRepository createAccountRepository, 
			PasswordEncoder passwordEncoder, UserMapper userMapper) {
		this.createAccountRepository =  createAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
	}
	
	public CreateAccountResponse createUser(CreateAccountRequest request) {
		log.debug("CreateAccountService.createUser: Starting Method");
		log.debug("CreateAccountService.createUser: request username = " + request.getUsername());
		
		if(request.getUsername() == null || request.getUsername().isBlank()) {
			throw new IllegalArgumentException("Username cannot be empty");
		}
		if(request.getPassword() == null || request.getPassword().isBlank()) {
			throw new IllegalArgumentException("Password cannot be empty");
		}
		
		//if username exists in db we throw exception
		createAccountRepository.findByUsername(request.getUsername())
				.ifPresent(u -> {
		            throw new DuplicateTitleException();
		        });

        // DTO → Entity
        Users user = userMapper.toEntity(request);
	    
	    //create user, error handling done by GlobalExceptionHandler class
	    createAccountRepository.save(user);

		CreateAccountResponse response = userMapper.toResponse(user);
		response.setResponseCodes(ResponseCodes.SUCCESS);
	    log.debug("CreateAccountService.createUser: response message = " + response.getResponseCodes().message());
		
        return response;
	}
}

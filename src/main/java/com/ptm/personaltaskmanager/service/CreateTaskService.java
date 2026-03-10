package com.ptm.personaltaskmanager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ptm.personaltaskmanager.database.CreateTaskRespository;
import com.ptm.personaltaskmanager.dto.CreateTaskRequest;
import com.ptm.personaltaskmanager.dto.CreateTaskResponse;
import com.ptm.personaltaskmanager.enums.ResponseCodes;
import com.ptm.personaltaskmanager.mapper.TaskMapper;
import com.ptm.personaltaskmanager.model.Tasks;

@Service
public class CreateTaskService {

	private static final Logger log = LoggerFactory.getLogger(CreateAccountService.class);
	private final CreateTaskRespository createTaskRespository;
	private final TaskMapper taskMapper;
	
	public CreateTaskService(CreateTaskRespository createTaskRespository,
			TaskMapper taskMapper) {
		this.createTaskRespository = createTaskRespository;
		this.taskMapper = taskMapper;
	}
	
	public CreateTaskResponse createTask(CreateTaskRequest request) {
		log.debug("CreateTaskService.createTask: Starting method");
		log.debug("CreateTaskService.createTask: username =" + request.getUsername());
		log.debug("CreateTaskService.createTask: task =" + request.getTask());
		log.debug("CreateTaskService.createTask: taskstatus =" + request.getStatus());
		log.debug("CreateTaskService.createTask: category =" + request.getCategory());
		
		if(request.getUsername() == null || request.getUsername().isBlank()) {
			throw new IllegalArgumentException("Username cannot be empty");
		}
		if(request.getTask() == null || request.getTask().isBlank()) {
			throw new IllegalArgumentException("Task cannot be empty");
		}
		//enums cannot be null so no check needed
		if(request.getCategory() == null || request.getCategory().isBlank()) {
			throw new IllegalArgumentException("Category cannot be empty");
		}
		
        // DTO → Entity
        Tasks task = taskMapper.toEntity(request);
		
		//create the task, error handling done by GlobalExceptionHandler class
        // Save to DB
        Tasks savedTask = createTaskRespository.save(task);

		CreateTaskResponse response = taskMapper.toResponse(savedTask);
		response.setResponseCodes(ResponseCodes.CREATED);
		log.debug("CreateTaskService.createTask: status = " + response.getResponseCodes().message());
		return response;
	}
}

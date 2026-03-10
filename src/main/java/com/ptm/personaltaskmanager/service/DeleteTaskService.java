package com.ptm.personaltaskmanager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ptm.personaltaskmanager.database.DeleteTaskRepository;
import com.ptm.personaltaskmanager.dto.DeleteTaskRequest;
import com.ptm.personaltaskmanager.dto.DeleteTaskResponse;
import com.ptm.personaltaskmanager.enums.ResponseCodes;
import com.ptm.personaltaskmanager.exception.TaskNotFoundException;
import com.ptm.personaltaskmanager.model.Tasks;

@Service
public class DeleteTaskService {

	private static final Logger log = LoggerFactory.getLogger(CreateAccountService.class);
	private final DeleteTaskRepository deleteTaskRepository;
	
	DeleteTaskService(DeleteTaskRepository deleteTaskRepository) {
		this.deleteTaskRepository = deleteTaskRepository;
	}
	
	public DeleteTaskResponse deleteTask(DeleteTaskRequest request) {
		log.debug("DeleteTaskService.deleteTask: Starting method");
		log.debug("DeleteTaskService.deleteTask: Task = " + request.getTask());
		log.debug("DeleteTaskService.deleteTask: Task Number = " + request.getTaskNumber());
		log.debug("DeleteTaskService.deleteTask: Username = " + request.getUsername());
		
		if(request.getUsername() == null || request.getUsername().isBlank()) {
			throw new IllegalArgumentException("Username is null");
		}
		if(request.getTaskNumber() == null) {
			throw new IllegalArgumentException("TaskNumber is null");
		}
		if(request.getTask() == null || request.getTask().isBlank()) {
			throw new IllegalArgumentException("Task is null");
		}
		
		Tasks task = deleteTaskRepository.findbyTaskNumber(request.getTaskNumber())
				.orElseThrow(() -> new TaskNotFoundException(request.getTask()));

	    if (!task.getUsername().equalsIgnoreCase(request.getUsername())) {
	        throw new IllegalArgumentException("Username does not match task owner");
	    }
	    
	    deleteTaskRepository.delete(task);

	    DeleteTaskResponse response = new DeleteTaskResponse();
	    response.setResponseCodes(ResponseCodes.SUCCESS);
		log.debug("DeleteTaskService.deleteTask: response status = " + response.getResponseCodes());
	    return response;
	}
}

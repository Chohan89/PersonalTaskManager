package com.ptm.personaltaskmanager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ptm.personaltaskmanager.database.UpdateTaskRepository;
import com.ptm.personaltaskmanager.dto.UpdateTaskRequest;
import com.ptm.personaltaskmanager.dto.UpdateTaskResponse;
import com.ptm.personaltaskmanager.enums.ResponseCodes;
import com.ptm.personaltaskmanager.exception.TaskNotFoundException;
import com.ptm.personaltaskmanager.mapper.TaskMapper;
import com.ptm.personaltaskmanager.model.Tasks;

public class UpdateTaskService {

	private static final Logger log = LoggerFactory.getLogger(CreateAccountService.class);
	private final UpdateTaskRepository updateTaskRepository;
	private TaskMapper taskMapper;
	
	public UpdateTaskService(UpdateTaskRepository updateTaskRepository,
			TaskMapper taskMapper) {
		this.updateTaskRepository = updateTaskRepository;
		this.taskMapper = taskMapper;
	}
	
	public UpdateTaskResponse updateTask(UpdateTaskRequest request) {
		log.debug("UpdateTaskService.updateTask: Starting method");
		log.debug("UpdateTaskService.updateTask: Task= " + request.getTask());
		log.debug("UpdateTaskService.updateTask: Status= " + request.getStatus());
		log.debug("UpdateTaskService.updateTask: Category= " + request.getCategory());
		log.debug("UpdateTaskService.updateTask: ID= " + request.getTaskNumber());

		//if task does not exist, throw error
		Tasks task = updateTaskRepository.findbyTaskNumber(request.getTaskNumber())
				.orElseThrow(() -> new TaskNotFoundException(request.getTask()));
		
		//make sure the username from request matches result's username from findbyID
		if (!task.getUsername().equals(request.getUsername())) {
		    throw new IllegalArgumentException("Username does not match task owner");
		}

		if(request.getTask() != null && !request.getTask().isBlank()) {
			task.setTask(request.getTask());
			log.debug("UpdateTaskService.updateTask: setting Task for db call = " + task.getTask());
		}
		if(request.getStatus() != null) {
			task.setStatus(request.getStatus());
			log.debug("UpdateTaskService.updateTask: setting Status for db call = " + task.getStatus());
		}
		if(request.getCategory() != null && !request.getCategory().isBlank()) {
			task.setCategory(request.getCategory());
			log.debug("UpdateTaskService.updateTask: setting Category for db call = " + task.getCategory());
		}
		if(request.getTaskNumber() != null) {
			task.setTaskNumber(request.getTaskNumber());
			log.debug("UpdateTaskService.updateTask: setting Task Number for db call = " + task.getTaskNumber());
		}
		
		//Apply partial updates using MapStruct
        taskMapper.updateTaskFromRequest(request, task);
        
        //Save updated task
		updateTaskRepository.save(task);
		
		UpdateTaskResponse response = new UpdateTaskResponse();
		response.setResponseCodes(ResponseCodes.SUCCESS);
		log.debug("UpdateTaskService.updateTask: response status = " + response.getResponseCodes());
		return response;
	}
}

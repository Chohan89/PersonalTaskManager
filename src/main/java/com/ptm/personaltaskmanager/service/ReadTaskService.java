package com.ptm.personaltaskmanager.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ptm.personaltaskmanager.database.ReadTasksRepository;
import com.ptm.personaltaskmanager.dto.ReadTasksRequest;
import com.ptm.personaltaskmanager.dto.ReadTasksResponse;
import com.ptm.personaltaskmanager.dto.TaskDto;
import com.ptm.personaltaskmanager.enums.ResponseCodes;
import com.ptm.personaltaskmanager.mapper.TaskMapper;
import com.ptm.personaltaskmanager.model.Tasks;

@Service
public class ReadTaskService {
	private static final Logger log = LoggerFactory.getLogger(CreateAccountService.class);
	private final ReadTasksRepository readTasksRepository;
	private final TaskMapper taskMapper;
	
	ReadTaskService(ReadTasksRepository readTasksRepository,
			TaskMapper taskMapper) {
		this.readTasksRepository = readTasksRepository;
		this.taskMapper = taskMapper;
	}
	
	public ReadTasksResponse readTask(ReadTasksRequest request) {
		log.debug("ReadTaskService.readTask: Starting method");
		log.debug("ReadTaskService.readTask: username = " + request.getUsername());
		
		if(request.getUsername() == null || request.getUsername().isBlank()) {
			throw new IllegalArgumentException("Username does not match task owner");
		}
        
		// Fetch tasks
		List<Tasks> tasks = readTasksRepository.findByUsername(request.getUsername());
		
        // Convert entity list → DTO list
        List<TaskDto> taskDtos = taskMapper.toDtoList(tasks);

		ReadTasksResponse response = new ReadTasksResponse();
		response.setResponseCodes(ResponseCodes.SUCCESS);
		response.setTasks(taskDtos);
		log.debug("ReadTaskService.readTask: response status = " + response.getResponseCodes());
		return response;
	}
}

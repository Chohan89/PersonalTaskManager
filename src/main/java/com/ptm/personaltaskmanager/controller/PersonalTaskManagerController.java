package com.ptm.personaltaskmanager.controller;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptm.personaltaskmanager.dto.CreateTaskRequest;
import com.ptm.personaltaskmanager.dto.CreateTaskResponse;
import com.ptm.personaltaskmanager.dto.DeleteTaskRequest;
import com.ptm.personaltaskmanager.dto.DeleteTaskResponse;
import com.ptm.personaltaskmanager.dto.ReadTasksRequest;
import com.ptm.personaltaskmanager.dto.ReadTasksResponse;
import com.ptm.personaltaskmanager.dto.UpdateTaskRequest;
import com.ptm.personaltaskmanager.dto.UpdateTaskResponse;
import com.ptm.personaltaskmanager.service.CreateTaskService;
import com.ptm.personaltaskmanager.service.DeleteTaskService;
import com.ptm.personaltaskmanager.service.ReadTaskService;
import com.ptm.personaltaskmanager.service.UpdateTaskService;

@RestController
@RequestMapping("/api/v1/task")
public class PersonalTaskManagerController {

	private static final Logger log = LoggerFactory.getLogger(PersonalTaskManagerController.class);
	private final CreateTaskService createTaskService;
	private final UpdateTaskService updateTaskService;
	private final ReadTaskService readTaskService;
	private final DeleteTaskService deleteTaskService;
	
	public PersonalTaskManagerController(CreateTaskService createTaskService,
			UpdateTaskService updateTaskService, ReadTaskService readTaskService, 
			DeleteTaskService deleteTaskService) {
		this.createTaskService = createTaskService;
		this.updateTaskService = updateTaskService;
		this.readTaskService = readTaskService;
		this.deleteTaskService = deleteTaskService;
	}
	
	@PostMapping("/createtask")
    public CreateTaskResponse createTask(@RequestBody CreateTaskRequest request) {
    	return createTaskService.createTask(request);
    }
	@PostMapping("/updatetask")
	public UpdateTaskResponse updateTask(@RequestBody UpdateTaskRequest request) {
		return updateTaskService.updateTask(request);
	}
	@PostMapping("/readtask")
	public ReadTasksResponse readTask(@RequestBody ReadTasksRequest request) {
		return readTaskService.readTask(request);
	}
	@PostMapping("/deletetask")
	public DeleteTaskResponse deleteTask(@RequestBody DeleteTaskRequest request) {
		return deleteTaskService.deleteTask(request);
	}
}

package com.ptm.personaltaskmanager.dto;

import com.ptm.personaltaskmanager.model.TaskStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTaskRequest {

	@NotBlank(message = "Username is required")
	@Size(min = 3, max = 30, message = "Username must be 3–30 characters")
	private String username;
	
	@NotBlank(message = "Task is required")
	@Size(max = 300, message = "Task cannot exceed 300 characters")
	private String task;
	
	@NotBlank(message = "Status is required")
	private TaskStatus status;
	
	@Size(max = 100, message = "Category cannot exceed 100 characters")
	@NotBlank(message = "Category is required")
	private String category;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}

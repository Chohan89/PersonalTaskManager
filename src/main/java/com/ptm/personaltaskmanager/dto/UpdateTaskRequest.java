package com.ptm.personaltaskmanager.dto;

import com.ptm.personaltaskmanager.model.TaskStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateTaskRequest {
	
	@Size(max = 300, message = "Task cannot exceed 300 characters")
	private String task;        // optional
	
    private TaskStatus status;   // optional enum
    
	@Size(max = 100, message = "Category cannot exceed 100 characters")
    private String category;     // optional
    
	@NotBlank(message = "Task Number is required")
	@Size(max = 100, message = "Task Number cannot exceed 100 characters")
    private Integer taskNumber;
    
	@NotBlank(message = "Username is required")
	@Size(min = 3, max = 30, message = "Username must be 3–30 characters")
	private String username;
    
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    public Integer getTaskNumber() {
		return taskNumber;
	}
	public void setTaskNumber(Integer taskNumber) {
		this.taskNumber = taskNumber;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String title) {
		this.task = title;
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

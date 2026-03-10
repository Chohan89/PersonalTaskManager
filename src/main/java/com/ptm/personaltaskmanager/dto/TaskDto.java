package com.ptm.personaltaskmanager.dto;

public class TaskDto {
	private Long taskNumber;
    private String task;
    private String status;
    private String category;

	public Long getTaskNumber() {
		return taskNumber;
	}
	public void setTaskNumber(Long taskNumber) {
		this.taskNumber = taskNumber;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}

package com.ptm.personaltaskmanager.dto;

import java.util.List;

import com.ptm.personaltaskmanager.enums.ResponseCodes;

public class ReadTasksResponse {
	private ResponseCodes responseCodes;
	private List<TaskDto> tasks;
	
	public List<TaskDto> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskDto> tasks) {
		this.tasks = tasks;
	}

	public ResponseCodes getResponseCodes() {
		return responseCodes;
	}

	public void setResponseCodes(ResponseCodes responseCodes) {
		this.responseCodes = responseCodes;
	}
}

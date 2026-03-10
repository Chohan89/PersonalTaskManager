package com.ptm.personaltaskmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ReadTasksRequest {
	
	@NotBlank(message = "Username is required")
	@Size(min = 3, max = 30, message = "Username must be 3–30 characters")
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}

package com.ptm.personaltaskmanager.dto;

import com.ptm.personaltaskmanager.enums.ResponseCodes;

public class LoginResponse {

	private String username;
	private ResponseCodes responseCodes;
	
	public ResponseCodes getResponseCodes() {
		return responseCodes;
	}

	public void setResponseCodes(ResponseCodes responseCodes) {
		this.responseCodes = responseCodes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}

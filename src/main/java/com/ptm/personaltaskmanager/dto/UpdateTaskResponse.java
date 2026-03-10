package com.ptm.personaltaskmanager.dto;

import com.ptm.personaltaskmanager.enums.ResponseCodes;

public class UpdateTaskResponse {
	private ResponseCodes responseCodes;
	
	public ResponseCodes getResponseCodes() {
		return responseCodes;
	}

	public void setResponseCodes(ResponseCodes responseCodes) {
		this.responseCodes = responseCodes;
	}
}

package com.ptm.personaltaskmanager.api;

import java.time.Instant;

import com.ptm.personaltaskmanager.enums.ResponseCodes;

public class ApiResponse {

    private ResponseCodes code;
    private String message;
	private Instant timestamp = Instant.now();
    
    public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

    public ApiResponse(ResponseCodes code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseCodes getCode() {
        return code;
    }

    public void setCode(ResponseCodes code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
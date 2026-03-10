package com.ptm.personaltaskmanager.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ptm.personaltaskmanager.api.ApiResponse;
import com.ptm.personaltaskmanager.enums.ResponseCodes;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> handleDataIntegrity(DataIntegrityViolationException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ApiResponse(ResponseCodes.ERROR, "Database constraint violation"));
    }

    @ExceptionHandler(TransactionSystemException.class)
    public ResponseEntity<ApiResponse> handleTransaction(TransactionSystemException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse(ResponseCodes.ERROR, "Transaction failed"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGeneric(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse(ResponseCodes.ERROR, "Unexpected server error"));
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleIllegalArgument(IllegalArgumentException ex) {
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    			.body(new ApiResponse(ResponseCodes.ERROR,ex.getMessage()));
    }
}
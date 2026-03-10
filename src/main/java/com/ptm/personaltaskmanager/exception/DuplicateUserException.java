package com.ptm.personaltaskmanager.exception;

public class DuplicateUserException extends RuntimeException{
	public DuplicateUserException() {
		super("Username already exists");
	}
}

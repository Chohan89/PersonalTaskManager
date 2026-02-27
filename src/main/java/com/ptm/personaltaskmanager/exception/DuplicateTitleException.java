package com.ptm.personaltaskmanager.exception;

public class DuplicateTitleException extends RuntimeException{
	public DuplicateTitleException() {
		super("Username already exists");
	}
}

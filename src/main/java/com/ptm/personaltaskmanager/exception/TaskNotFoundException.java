package com.ptm.personaltaskmanager.exception;

public class TaskNotFoundException extends RuntimeException{
	public TaskNotFoundException(String task) {
		super("Task not found: " + task);
	}
}

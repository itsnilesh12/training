package com.howtodoinjava.demo.error;

public class EmployeeNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public EmployeeNotFound(Long id) {
		super("Employee not found : " + id);
	}

}
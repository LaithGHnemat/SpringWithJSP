package com.laith.robotake.JSPSpringBoot.exceptions;

public class DepartmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4157197229807466509L;
	public DepartmentNotFoundException(String message) {
        super(message);
    }
}

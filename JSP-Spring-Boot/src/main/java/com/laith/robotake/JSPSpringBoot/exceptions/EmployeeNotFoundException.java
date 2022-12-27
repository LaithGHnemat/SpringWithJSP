package com.laith.robotake.JSPSpringBoot.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1019300340834441852L;
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

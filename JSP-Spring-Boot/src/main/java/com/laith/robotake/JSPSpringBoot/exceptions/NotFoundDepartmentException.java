package com.laith.robotake.JSPSpringBoot.exceptions;

public class NotFoundDepartmentException extends RuntimeException {

    private static final long serialVersionUID = -609646991580526520L;
    public NotFoundDepartmentException(String message) {
        super(message);
    }
}

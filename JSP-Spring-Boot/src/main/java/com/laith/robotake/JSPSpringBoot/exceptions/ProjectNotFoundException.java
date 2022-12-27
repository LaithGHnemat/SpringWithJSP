package com.laith.robotake.JSPSpringBoot.exceptions;

public class ProjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1129665311468813850L;
    public ProjectNotFoundException(String message) {
        super(message);
    }
}

package com.laith.robotake.JSPSpringBoot.model;

public enum EmployeeRole {
    ROLE_ADMIN, ROLE_USER;
    static public EmployeeRole forTypeIgnoreCase(String value) {
        for (EmployeeRole type : EmployeeRole.values()) {
            if (type.name().equalsIgnoreCase(value))
                return type;
        }
        return null;
    }
}

package com.laith.robotake.JSPSpringBoot.service;

import com.laith.robotake.JSPSpringBoot.exceptions.NotFoundDepartmentException;
import com.laith.robotake.JSPSpringBoot.model.Department;

import java.util.List;
import java.util.Map;

public interface IDepartmentService {
    List<Department> getAllDepartment();
    Department addDepartment(Department department);
    Department updateDepartment(Department department);
    Map<String, Boolean> deleteDepartment(Long departmentId);
    Department findDepartmentById(Long id);

}

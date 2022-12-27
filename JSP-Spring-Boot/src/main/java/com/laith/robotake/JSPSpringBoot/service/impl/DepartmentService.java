package com.laith.robotake.JSPSpringBoot.service.impl;

import com.laith.robotake.JSPSpringBoot.exceptions.DepartmentNotFoundException;
import com.laith.robotake.JSPSpringBoot.exceptions.NotFoundDepartmentException;
import com.laith.robotake.JSPSpringBoot.model.Department;
import com.laith.robotake.JSPSpringBoot.repository.DepartmentRepository;
import com.laith.robotake.JSPSpringBoot.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeService employeeService;


	public List<Department> getAllDepartment() {
		return this.departmentRepository.findAll();
	}


	public Department addDepartment(Department department) {

		return this.departmentRepository.save(department);

	}


	public Department updateDepartment(Department department) throws NotFoundDepartmentException {
		return this.departmentRepository.save(department);
	}


	public Map<String, Boolean> deleteDepartment(Long departmentId) throws NotFoundDepartmentException {
		Department department = departmentRepository.findById(departmentId).orElseThrow(
				() -> new NotFoundDepartmentException("Department not found for this id :: " + departmentId));

		department.getEmployees().forEach((emp) -> {
			emp.setDepartment(null);
			employeeService.updateEmployee(emp);
		});
		departmentRepository.delete(department);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	public Department findDepartmentById(Long id) {
		return departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException("Department by id " + id + " was not found"));
	}

}

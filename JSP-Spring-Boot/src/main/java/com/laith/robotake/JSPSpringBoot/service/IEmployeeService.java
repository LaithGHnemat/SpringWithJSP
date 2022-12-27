package com.laith.robotake.JSPSpringBoot.service;

import com.laith.robotake.JSPSpringBoot.dto.EmployeeDTO;
import com.laith.robotake.JSPSpringBoot.model.Employee;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IEmployeeService extends UserDetailsService {
    Employee addEmployee(Employee employee);

     List<Employee> findAllEmployees();

    Employee updateEmployee(Employee employee);

    Employee findEmployeeById(Long id);

    void deleteEmployee(Long id);
    Employee findEmployeeByHisEmailNamedNativeQuery(String email);

    List<EmployeeDTO> findEmployeebyDTO();


     boolean validateUserNameAndPassword(String username, String password);

    UserDetails loadUserByUsername(String username);
}

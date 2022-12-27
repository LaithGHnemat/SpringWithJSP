package com.laith.robotake.JSPSpringBoot.service.impl;


import com.laith.robotake.JSPSpringBoot.dto.EmployeeDTO;
import com.laith.robotake.JSPSpringBoot.exceptions.EmployeeNotFoundException;
import com.laith.robotake.JSPSpringBoot.exceptions.ProjectNotFoundException;
import com.laith.robotake.JSPSpringBoot.model.Employee;
import com.laith.robotake.JSPSpringBoot.repository.EmployeeRepository;
import com.laith.robotake.JSPSpringBoot.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //@Transactional(readOnly = f)
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();

    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee by id " + id + " was not found"));
    }

    @Transactional
    public void deleteEmployee(Long id){
        // first step we found the Project by its id.
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ProjectNotFoundException("" +
                        "we can't delete this project couz it's " +
                        " there is no employee with this id :" + id));
        // second step delete the relation between the project and its employees.
          employee.removeAllProjects();

        // end step delete the employee itself
        employeeRepository.deleteById(id);
    }

   /* public List<EmployeeDTO>  getEmployeesWhereWorking(){
        return employeeRepository.whereEmployeeWork();
    }*/


    public Employee findEmployeeByHisEmailNamedNativeQuery(String email) {
        return employeeRepository.findByEmailAddress(email);

    }

    public List<EmployeeDTO> findEmployeebyDTO() {
        return employeeRepository.findEmployeeDTO();

    }

    public boolean validateUserNameAndPassword(String username, String password){

        Optional<Employee> emp = Optional.ofNullable(
                employeeRepository.checkUsernameAndPassword(username,password));
        return emp.isPresent();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Employee employee = employeeRepository.findByUserName(username);
        if (employee==null) {
            throw new UsernameNotFoundException("Username not found");
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(employee.getEmployeeRole().toString());
        UserDetails userDetails =
                new User(employee.getUserName(),
                        employee.getPassword(),
                        Arrays.asList(authority));
        return userDetails;
    }
}

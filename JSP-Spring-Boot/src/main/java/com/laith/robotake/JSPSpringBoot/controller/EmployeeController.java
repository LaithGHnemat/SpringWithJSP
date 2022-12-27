package com.laith.robotake.JSPSpringBoot.controller;


import com.laith.robotake.JSPSpringBoot.dto.EmployeeDTO;
import com.laith.robotake.JSPSpringBoot.model.Employee;
import
        com.laith.robotake.JSPSpringBoot.service.impl.EmployeeService;
import
        org.springframework.beans.factory.annotation.Autowired;
import
        org.springframework.http.HttpStatus;
import
        org.springframework.http.ResponseEntity;
import
        org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employeee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        List<EmployeeDTO> employeeDtos = employees.stream().map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary(),
                emp.getDepartment().getLocation())).collect(Collectors.toList());
        return employeeDtos;
    }

    @GetMapping("/all-entities")//@JsonBackReference+ named querey
    public List<EmployeeDTO> getAllEmployeesJsonBackReference() {
        List<Employee> employees = employeeService.findAllEmployees();
        List<EmployeeDTO> employeeDtos = employees.stream().map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary(),
                emp.getDepartment().getLocation())).collect(Collectors.toList());
        return employeeDtos;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById
            (@PathVariable("id") Long id) {
        Employee employee =
                employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee,
                HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody
                                                Employee employee) {
        Employee newEmployee =
                employeeService.addEmployee(employee);
        return new
                ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee>
    updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee =
                employeeService.updateEmployee(employee);
        return new
                ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>
    deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new
                ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/findByEmail")
    public ResponseEntity<EmployeeDTO> getByEmailToTestNamedQuery() {
        Employee employee = employeeService.
                findEmployeeByHisEmailNamedNativeQuery("aya@farabi.ae");
        EmployeeDTO employeeDtos = new EmployeeDTO(employee.getName(), employee.getSalary(),
                employee.getDepartment().getLocation());
        return new ResponseEntity<>(employeeDtos, HttpStatus.OK);
    }

    @GetMapping("/allUsingGsonBackReference")
    public List<Employee > getAllEmployeesU() {
        List<Employee> employees = employeeService.findAllEmployees();
        return employees;
    }

    @GetMapping("/fromMultiTables")
    public List<EmployeeDTO > getEmployeeWithTheirLocation() {
        List<EmployeeDTO> employees = employeeService.findEmployeebyDTO();
        return employees;
    }

}

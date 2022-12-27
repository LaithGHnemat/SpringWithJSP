package com.laith.robotake.JSPSpringBoot.controller;

import java.util.List;

import com.laith.robotake.JSPSpringBoot.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.laith.robotake.JSPSpringBoot.model.Employee;
import com.laith.robotake.JSPSpringBoot.service.impl.EmployeeService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeMVC {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView displayAll() {
		ModelAndView employeeModel = new ModelAndView();
		List<Employee> employees = employeeService.findAllEmployees();
		employeeModel.addObject("employees", employees);
		employeeModel.setViewName("employee_list");
		return employeeModel;
	}

	@RequestMapping(value = "/insertPage", method = RequestMethod.GET)
	public ModelAndView addArticle() {
		ModelAndView model = new ModelAndView();
		Employee employee = new Employee();
		model.addObject("employeeForm", employee);
		model.setViewName("insertPage");
		return model;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertEmployee(@ModelAttribute("employeeForm") Employee e) {
		employeeService.addEmployee(e);
		return new ModelAndView("redirect:/employee/list");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET) 
	public @ResponseBody boolean deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(Long.valueOf(id));
		return true;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView goToUpdatePage(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView();
		Employee e = employeeService.findEmployeeById(Long.valueOf(id));
		model.addObject("employeeForm", e);
		model.setViewName("insertPage");
		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ModelAndView updatetEmployee(@ModelAttribute("employeeForm") Employee e) {
		employeeService.updateEmployee(e);
		return new ModelAndView("redirect:/employee/list");
	}


	@RequestMapping(value = "/emp-viw", method = RequestMethod.GET)
	public ModelAndView displayEmp() {
		ModelAndView employeeModel = new ModelAndView();
		List<EmployeeDTO> employees = employeeService.findEmployeebyDTO();
		employeeModel.addObject("ListEmployeebyDTO", employees);
		employeeModel.setViewName("emp-info");
		return employeeModel;
	}

}

package com.laith.robotake.JSPSpringBoot.controller;

import com.laith.robotake.JSPSpringBoot.model.Department;
import com.laith.robotake.JSPSpringBoot.service.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView displayAll() {
        ModelAndView departmentModel = new ModelAndView();
        List<Department> departments = departmentService.getAllDepartment();
        departmentModel.addObject("departments", departments);
        departmentModel.setViewName("departmentsList");
        return departmentModel;
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteDepartment(@PathVariable("id") int id) {
        departmentService.deleteDepartment(Long.valueOf(id));
        return new ModelAndView("redirect:/department/list");
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateDepartment(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView();
        Department e = departmentService.findDepartmentById(Long.valueOf(id));
        model.addObject("departmentForm", e);
        model.setViewName("deptInsertPage");
        return model;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insertDepartment(@ModelAttribute("departmentForm") Department department) {
        departmentService.addDepartment(department);
        return new ModelAndView("redirect:/department/list");
    }


    @RequestMapping(value = "/insertDepartment", method = RequestMethod.GET)
    public ModelAndView addDept() {
        ModelAndView model = new ModelAndView();
        Department department = new Department();
        model.addObject("departmentForm", department);
        model.setViewName("deptInsertPage");
        return model;
    }


}

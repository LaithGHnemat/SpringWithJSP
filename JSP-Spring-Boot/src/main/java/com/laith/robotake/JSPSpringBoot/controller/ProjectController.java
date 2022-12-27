package com.laith.robotake.JSPSpringBoot.controller;


import com.laith.robotake.JSPSpringBoot.model.Project;

import com.laith.robotake.JSPSpringBoot.service.impl.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView displayAll() {
        ModelAndView projectModel = new ModelAndView();
        List<Project> projects = projectService.getAllProject();
        projectModel.addObject("projects", projects);
        projectModel.setViewName("projectsList");
        return projectModel;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteDepartment(@PathVariable("id") int id) {
        projectService.deleteProject(Long.valueOf(id));
        return new ModelAndView("redirect:/project/list");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView updateProject(@PathVariable("id") int id) {
        ModelAndView model = new ModelAndView();
        Project project = projectService.findProjectById(Long.valueOf(id));
        model.addObject("projectForm", project);
        model.setViewName("projectInsertPage");
        return model;
    }

   @RequestMapping(value = "/insert", method = RequestMethod.POST)
   public ModelAndView insertProject(@ModelAttribute("projectForm") Project p) {
       projectService.addProject(p);
       return new ModelAndView("redirect:/project/list");
   }
}

package com.laith.robotake.JSPSpringBoot.service;

import com.laith.robotake.JSPSpringBoot.model.Project;

import java.util.List;

public interface IProjectService {
    List<Project> getAllProject();
    Project addProject(Project project);
    Project updateProject(Project project);

    void deleteProject(Long id);

    Project findProjectById(Long id);
}

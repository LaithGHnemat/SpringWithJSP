package com.laith.robotake.JSPSpringBoot.service.impl;

import com.laith.robotake.JSPSpringBoot.exceptions.NotFoundDepartmentException;
import com.laith.robotake.JSPSpringBoot.exceptions.ProjectNotFoundException;
import com.laith.robotake.JSPSpringBoot.model.Project;
import com.laith.robotake.JSPSpringBoot.repository.ProjectRepository;
import com.laith.robotake.JSPSpringBoot.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;



    public List<Project> getAllProject() {
        return this.projectRepository.findAll();
    }


    public Project addProject(Project project) {
        return this.projectRepository.save(project);
    }

    // update
    public Project updateProject(Project project)throws NotFoundDepartmentException {
        return this.projectRepository.save(project);
    }
     @Transactional
    public void deleteProject(Long id){
        // first step we found the Project by its id.
        Project project = projectRepository.findById(id).orElseThrow(
                () -> new ProjectNotFoundException("" +
                        "we can't delete this project couz it's " +
                        " there is no project with this id :" + id));

         // second step delete the relation between the project and its employees.
        project.removeAllEmployees();
        // end step delete the project itself
        projectRepository.deleteById(id);

    }

    public Project findProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() ->
                        new ProjectNotFoundException("Project by id " +
                                "" + id + " was not found"));
    }

}

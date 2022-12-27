package com.laith.robotake.JSPSpringBoot.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Project")
@Setter
@Getter
public class Project implements Serializable {

	private static final long serialVersionUID = 5512462574505002760L;
	
	@Id
    @Column(name = "project_id")
    @GeneratedValue
    private Long projectId;
    private String name;
    private String owner;
    private String Location;
    private String title;
    @ManyToMany()
    @JoinTable(
            name = "Employee_Project",
            joinColumns = { @JoinColumn(name = "project_id") },
            inverseJoinColumns = { @JoinColumn(name = "employee_id") }
    )
    @JsonBackReference
    private Set<Employee> employees = new HashSet<>();
    public void removeAllEmployees() {
    	for(Employee emp : employees) {
    		emp.getProjects().remove(this);
    	}
    	this.employees.clear();
    }

}

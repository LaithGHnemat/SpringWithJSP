package com.laith.robotake.JSPSpringBoot.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.laith.robotake.JSPSpringBoot.dto.EmployeeDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee_details")
@Setter
@Getter
@NamedNativeQuery(name = "Employee.findByEmailAddress",
        query = "select * from employee_details where employee_details.email = ?1",
        resultClass = Employee.class)


@NamedNativeQuery(name = "Employee.checkUsernameAndPassword",
        query = "select * from employee_details where " +
                "employee_details.user_name = ?1" +
                " and " +
                " employee_details.password= ?2 ",
        resultClass = Employee.class)


@NamedNativeQuery(name = "Employee.findEmployeeDTO",
        query = "select  employee_details.name AS name,salary AS sal," +
                " dep_details.Location AS Location" +
                " FROM employee_details" +
                " left join dep_details" +
                " on employee_details.department_id = dep_details.id",
        resultSetMapping = "Mapping.EmployeeDTO")

@SqlResultSetMapping(name = "Mapping.EmployeeDTO",
        classes = @ConstructorResult(targetClass = EmployeeDTO.class,
                columns = {@ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "sal", type = Double.class),
                        @ColumnResult(name = "location", type = String.class)
                }))
public class Employee implements Serializable {

    private static final long serialVersionUID = 8536165658955982507L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private double salary;
    @ManyToOne()
    @JoinColumn(name = "department_id")
    @JsonManagedReference
    private Department department;
    @ManyToMany(mappedBy = "employees")
    @JsonManagedReference
    Set<Project> projects = new HashSet<>();

    private String userName;
    private String password;

    @Enumerated(EnumType.STRING)
    private EmployeeRole employeeRole;

    /*@OneToOne()
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;*/

    // This method for remove the associations with the employees.
    public void removeAllProjects() {
        for (Project pro : projects) {
            pro.getEmployees().remove(this);
        }
        this.projects.clear();
    }



   /*
     @JsonManagedReference is the forward part of reference – the one that gets serialized normally.
     @JsonBackReference is the back part of reference – it will be deleted from serialization.

     if we don't add those annotations, we will find problems
     because emp and dept inside each other
    */

    /*
     the default
    OneToMany: LAZY
    ManyToOne: EAGER
    ManyToMany: LAZY
    OneToOne: EAGER
    */

}

package com.laith.robotake.JSPSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "dep_details")
@Data
public class Department implements Serializable {

	private static final long serialVersionUID = 2803503524839707806L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String location;
	@OneToMany(mappedBy = "department", cascade = {
			CascadeType.DETACH,
			CascadeType.REFRESH,
			CascadeType.MERGE,
			CascadeType.PERSIST })
	@JsonBackReference
	private List<Employee> employees;

}

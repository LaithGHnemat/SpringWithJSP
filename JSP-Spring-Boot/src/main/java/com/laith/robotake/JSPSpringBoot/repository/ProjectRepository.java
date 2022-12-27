package com.laith.robotake.JSPSpringBoot.repository;

import com.laith.robotake.JSPSpringBoot.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}

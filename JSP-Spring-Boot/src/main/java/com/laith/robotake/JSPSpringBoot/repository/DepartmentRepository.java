package com.laith.robotake.JSPSpringBoot.repository;

import com.laith.robotake.JSPSpringBoot.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}

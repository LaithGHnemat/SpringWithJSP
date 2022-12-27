package com.laith.robotake.JSPSpringBoot.repository;


import com.laith.robotake.JSPSpringBoot.dto.EmployeeDTO;
import com.laith.robotake.JSPSpringBoot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    Employee findByEmailAddress(String emailAddress);// this named native query.

    @Query(nativeQuery = true)
    List<EmployeeDTO> findEmployeeDTO();

    @Query(nativeQuery = true)
    Employee checkUsernameAndPassword(String username,String password);

    Employee findByUserName(String username);


}

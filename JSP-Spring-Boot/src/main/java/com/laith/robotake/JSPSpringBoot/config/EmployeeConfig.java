package com.laith.robotake.JSPSpringBoot.config;

import com.laith.robotake.JSPSpringBoot.model.*;
import com.laith.robotake.JSPSpringBoot.repository.*;
import com.laith.robotake.JSPSpringBoot.service.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;


import java.util.HashSet;
import java.util.Set;

@Configuration
@Transactional
public class EmployeeConfig {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private PasswordEncoder passEnc;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private AuthenticationManagerBuilder auth;

   /* @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;*/


    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            insertData();
        };

    }

    private void insertData() {
    	System.out.println("*************");
    	System.out.println(passEnc.encode("massad"));
    	System.out.println(passEnc.encode("massad"));
    	System.out.println(passEnc.encode("massad"));
    	System.out.println("*************");
    	
    	try {
			boolean isExist =
					auth.inMemoryAuthentication()
							.getUserDetailsService()
							.userExists("a");
			
			System.out.println("isExist: " + isExist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       /* Role manager =new Role();
        manager.setEmployeeRoll(EmployeeRoll.MANAGER);
        roleRepository.save(manager);

        Role normal =new Role();
        normal.setEmployeeRoll(EmployeeRoll.USER);
        roleRepository.save(normal);



        Set<Role> managerList= new HashSet<>();
        managerList.add(manager);

        Set<Role> normalList= new HashSet<>();
        managerList.add(normal);

        User userAsManager = new User();
        userAsManager.setUserName("admin");
        userAsManager.setPassword("admin");
        userAsManager.setRoles(normalList);
        userRepository.save(userAsManager);


        User userAsNormal = new User();
        userAsNormal.setUserName("user");
        userAsNormal.setPassword("user123");
        userAsNormal.setRoles(managerList);
        userRepository.save(userAsNormal);*/




        //Departments
        Department department1 = new Department();
        department1.setId(Long.valueOf(1));
        department1.setLocation("Amman");
        department1.setName("IT");

        Department department2 = new Department();
        department2.setId(Long.valueOf(2));
        department2.setLocation("Ramallah");
        department2.setName("Management");

        Department department3 = new Department();
        department3.setId(Long.valueOf(3));
        department3.setLocation("Jerusalem");
        department3.setName("Management");

        Department department4 = new Department();
        department4.setId(Long.valueOf(4));
        department4.setLocation("Barcalona");
        department4.setName("Transportation");

        departmentService.addDepartment(department1);
        departmentService.addDepartment(department2);
        departmentService.addDepartment(department3);
        departmentService.addDepartment(department4);


        //  here the end of departments


        // projects
        Project hospital = new Project();
        hospital.setName("isara");
        hospital.setOwner("Sr.Ali");
        hospital.setTitle("first project");
        hospital.setProjectId(Long.valueOf(1));
        hospital.setLocation("Amman");


        Project hospital2 = new Project();
        hospital2.setName("Jordan");
        hospital2.setOwner("Sr.Mohammad");
        hospital2.setTitle("Secound project");
        hospital2.setProjectId(Long.valueOf(2));
        hospital2.setLocation("Ramallah");
        
        Set<Project> projects = new HashSet<>();

        projects.add(hospital);
        projects.add(hospital2);

        //

        Employee laith = new Employee();
        laith.setName("Laith Ghnemat");
        laith.setEmail("laith@farabi.ae");
        laith.setSalary(407.2);
        laith.setDepartment(department1);
        laith.setProjects(projects);

        laith.setUserName("laith");
        laith.setPassword(bCryptPasswordEncoder.encode("laith"));
        laith.setEmployeeRole(EmployeeRole.ROLE_ADMIN);
       // laith.setUser(userAsManager);


        Employee mohannad = new Employee();
        mohannad.setName("mohannad");
        mohannad.setEmail("mohannad@farabi.ae");
        mohannad.setSalary(505.2);
        mohannad.setDepartment(department2);
        mohannad.setProjects(projects);
        mohannad.setUserName("mohannad");
        mohannad.setPassword(bCryptPasswordEncoder.encode("mohannad"));
        mohannad.setEmployeeRole(EmployeeRole.ROLE_USER);


      //  mohannad.setUser(userAsNormal);


        Employee aya = new Employee();
        aya.setName("aya");
        aya.setEmail("aya@farabi.ae");
        aya.setDepartment(department3);
        aya.setSalary(859.2);
     //   aya.setUser(userAsNormal);
        aya.setProjects(projects);
        aya.setUserName("aya");
        aya.setPassword(bCryptPasswordEncoder.encode("aya"));
        aya.setEmployeeRole(EmployeeRole.ROLE_USER);



        Employee dalal = new Employee();
        dalal.setName("peter");
        dalal.setEmail("peter@farabi.ae");
        dalal.setDepartment(department4);
      //  dalal.setUser(userAsNormal);
        dalal.setSalary(874);
        dalal.setProjects(projects);

        dalal.setUserName("dalal");
        dalal.setPassword(bCryptPasswordEncoder.encode("dalal"));
        dalal.setEmployeeRole(EmployeeRole.ROLE_USER);

        employeeRepository.save(laith);
        employeeRepository.save(mohannad);
        employeeRepository.save(aya);
        employeeRepository.save(dalal);
        
        Set<Employee> hospitalEmps = new HashSet<>();

        hospitalEmps.add(laith);
        hospitalEmps.add(mohannad);
        hospitalEmps.add(aya);
        hospitalEmps.add(dalal);
        
        hospital.setEmployees(hospitalEmps);
        hospital2.setEmployees(hospitalEmps);
        
        projectRepository.save(hospital2);
        projectRepository.save(hospital);
    }

}

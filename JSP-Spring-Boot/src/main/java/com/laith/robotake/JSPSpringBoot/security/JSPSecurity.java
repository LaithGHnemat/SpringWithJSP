

package com.laith.robotake.JSPSpringBoot.security;

import com.laith.robotake.JSPSpringBoot.service.impl.EmployeeService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Log
public class JSPSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login",
                        "/css/**", "/js/**","/fonts/**","/images/**","/vendor/**").permitAll()
                .antMatchers("/welcome").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin( form -> form
                   
                        .loginPage("/login")
                        .defaultSuccessUrl("/welcome", true)
                        .failureUrl("/login?error=true")


                );
	http.csrf().disable();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employeeService).passwordEncoder(passwordEncoder());
    }

    /*@Override// this we in memory
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    	auth.inMemoryAuthentication()
    	    .passwordEncoder(passwordEncoder())
    			.withUser("a")
    			    .password(passwordEncoder().encode("a"))
    			    .roles("ADMIN", "USER")
    		.and()
    			.withUser("u")
    			    .password(passwordEncoder().encode("u"))
    			    .roles("ADMIN");
    }*/
}



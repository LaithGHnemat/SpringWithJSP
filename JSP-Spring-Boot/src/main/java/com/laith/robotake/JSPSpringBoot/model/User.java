/*
package com.laith.robotake.JSPSpringBoot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sec_users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sec_user_roles"
            , joinColumns = @JoinColumn(name= "user_id")
            , inverseJoinColumns = @JoinColumn (name = "role_id"))
    private Set<Role> roles = new HashSet<Role>();

}
*/

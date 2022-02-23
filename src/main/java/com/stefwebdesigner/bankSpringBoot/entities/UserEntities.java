package com.stefwebdesigner.bankSpringBoot.entities;

import javax.persistence.*;

@Entity
public class UserEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;

    //CONSTRUCTORS FOR ALL USER ENTITIES
    public UserEntities(String username, String email, String password) {
//        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserEntities(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

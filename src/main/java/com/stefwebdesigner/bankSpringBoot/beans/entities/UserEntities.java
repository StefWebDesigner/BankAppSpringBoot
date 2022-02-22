package com.stefwebdesigner.bankSpringBoot.beans.entities;

import javax.persistence.*;

@Entity
public class UserEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;

    //CONSTRUCTORS FOR ALL USER ENTITIES
    public UserEntities(Integer userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserEntities(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

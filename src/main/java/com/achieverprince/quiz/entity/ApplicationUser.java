package com.achieverprince.quiz.entity;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.net.Authenticator;

@Entity
public class ApplicationUser {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String name;
    private String email;
    private String gender;
    private String password;

    public ApplicationUser(){
        super();
    }

    public ApplicationUser(String userName, String name, String email, String gender, String password) {
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("ApplicationUser [id=%s, name=%s, email=%s, gender=%s]", id, name, email, gender);
    }
}

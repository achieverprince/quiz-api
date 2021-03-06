package com.achieverprince.quiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.List;

@Entity
@Cacheable(false)
@Cache(usage = CacheConcurrencyStrategy.NONE)
public class ApplicationUser {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String name;
    private String email;
    private String gender;
    @JsonIgnore
    private String password;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="USER_ROLES",
            joinColumns = @JoinColumn( name="id"),
            inverseJoinColumns = @JoinColumn( name="role_code")
    )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonIgnore
    private List<Role> roles;

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

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("ApplicationUser [id=%s, name=%s, email=%s, gender=%s]", id, name, email, gender);
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

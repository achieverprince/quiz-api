package com.achieverprince.quiz.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Privilege {
    @Id
    @Column(length = 100)
    private String privilegeCode;
    private String privilegeName;
    @Column(length = 1000)
    private String description;
    @ManyToOne
    @JoinColumn(name="roleCode", nullable=false)
    private Role role;

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

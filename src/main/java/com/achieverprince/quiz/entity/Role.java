package com.achieverprince.quiz.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @Column(length = 100)
    private String roleCode;
    private String roleName;
    @Column(length = 1000)
    private String description;
    @OneToMany(mappedBy="role", fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    private List<Privilege> privileges;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}

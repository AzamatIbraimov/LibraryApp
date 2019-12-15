package com.library.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Bean;

@Entity
public class User {

    @Id
    @Column(unique = true)
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "departament")
    private String departament;
    @Column(name = "is_active")
    private boolean isActive;
    @Size(min = 4)
    private String password;

    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "recovery_code")
    private String recoveryCode;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Retrievement> retrievements;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns={
            @JoinColumn(name = "USER_EMAIL", referencedColumnName = "email") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "name") })
    private List<Role> roles;

    public User() {
    }

    public User(String email, String name, String departament, boolean isActive, @Size(min = 4) String password, String activationCode, String recoveryCode, List<Retrievement> retrievements, List<Role> roles) {
        this.email = email;
        this.name = name;
        this.departament = departament;
        this.isActive = isActive;
        this.password = password;
        this.activationCode = activationCode;
        this.recoveryCode = recoveryCode;
        this.retrievements = retrievements;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getRecoveryCode() {
        return recoveryCode;
    }

    public void setRecoveryCode(String recoveryCode) {
        this.recoveryCode = recoveryCode;
    }

    public List<Retrievement> getRetrievements() {
        return retrievements;
    }

    public void setRetrievements(List<Retrievement> retrievements) {
        this.retrievements = retrievements;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
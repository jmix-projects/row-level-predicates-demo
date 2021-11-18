package com.company.helpcuba2jmix.entity;

import com.company.helpcuba2jmix.entity.User;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.securitydata.entity.ResourceRoleEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@JmixEntity
@Table(name = "HELPCUBA2JMIX_NOTE_TYPE")
@Entity(name = "helpcuba2jmix_NoteType")
public class NoteType extends StandardEntity {
    private static final long serialVersionUID = -6686397321171021927L;

    @InstanceName
    @NotNull
    @Column(name = "DESCRIPTION", nullable = false, unique = true)
    private String description;

    @JoinTable(name = "HELPCUBA2JMIX_NOTE_TYPE_USER_LINK",
            joinColumns = @JoinColumn(name = "NOTE_TYPE_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    @ManyToMany
    private List<User> allowedUsers;

    @JoinTable(name = "HELPCUBA2JMIX_NOTE_TYPE_ROLE_LINK",
            joinColumns = @JoinColumn(name = "NOTE_TYPE_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    @ManyToMany
    private List<ResourceRoleEntity> allowedRoles;

    public List<ResourceRoleEntity> getAllowedRoles() {
        return allowedRoles;
    }

    public void setAllowedRoles(List<ResourceRoleEntity> allowedRoles) {
        this.allowedRoles = allowedRoles;
    }

    public List<User> getAllowedUsers() {
        return allowedUsers;
    }

    public void setAllowedUsers(List<User> allowedUsers) {
        this.allowedUsers = allowedUsers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
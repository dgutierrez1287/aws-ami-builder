package com.diegog.amibuilder.domain


import javax.persistence.*
import javax.validation.constraints.*


/**
 * Author: dgutierrez
 * Project entity this represents users in the ami-builder application
 */

@Entity
@Table(name = "Users")
class User {

    // Fields //
    @Id
    @Column(name = "username", unique = true, nullable = false, length = 200)
    @NotNull
    private String username

    @Column(name = "password_hash", nullable = false, length = 200)
    @NotNull
    private String passwordHash

    @Column(name = "email", length = 200)
    private String email

    @Column(name = "is_super_user", nullable = false)
    @NotNull
    private boolean isSuperUser

    @ManyToMany(mappedBy = "users", cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    private Set<Project> projects

    // Methods //
    // Constructor(s)
    public User() { }

    public User(String username, String passwordHash, String email, boolean isSuperUser) {
        this.username = username
        this.passwordHash = passwordHash
        this.email = email
        this.isSuperUser = isSuperUser

        this.projects = Collections.<Project>emptySet()
    }

    public User(String username, String passwordHash, boolean isSuperUser) {
        this.username = username
        this.passwordHash = passwordHash
        this.isSuperUser = isSuperUser

        this.projects = Collections.<Project>emptySet()
    }

    // Getters and Setters
    String getUsername() {
        return username
    }

    void setUsername(String username) {
        this.username = username
    }

    String getPasswordHash() {
        return passwordHash
    }

    void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash
    }

    String getEmail() {
        return email
    }

    void setEmail(String email) {
        this.email = email
    }

    boolean getIsSuperUser() {
        return isSuperUser
    }

    void setIsSuperUser(boolean isSuperUser) {
        this.isSuperUser = isSuperUser
    }

    Set<Project> getProjects() {
        return projects
    }

    void setProjects(Set<Project> projects) {
        this.projects = projects
    }
}

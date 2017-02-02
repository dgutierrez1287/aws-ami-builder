package com.diegog.amibuilder.domain

import javax.persistence.*
import javax.validation.constraints.*

/**
 * Author: dgutierrez
 * Project entity this represents environments in the ami-builder application
 */
@Entity
@Table(name = "Environments")
class Environment {

    // Fields //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private long id

    @Column(name = "name", nullable = false, length = 100)
    @NotNull
    private String name

    @Column(name = "auto_deploy", nullable = false)
    @NotNull
    private boolean autoDeploy

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = "project_id", nullable = false)
    @NotNull
    private Project project

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = "build_id", nullable = true)
    private Build build


    // Methods //
    // Constructor(s)
    public Environment() { }

    public Environment(String name, boolean autoDeploy, Project project) {
        this.name = name
        this.autoDeploy = autoDeploy
        this.project = project

        this.build = null
    }

    public Environment(String name, Project project) {
        this.name = name
        this.autoDeploy = false
        this.project = project

        this.build = null
    }

    // Getters and Setters
    long getId() {
        return id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    boolean getAutoDeploy() {
        return autoDeploy
    }

    void setAutoDeploy(boolean autoDeploy) {
        this.autoDeploy = autoDeploy
    }

    Project getProject() {
        return project
    }

    void setProject(Project project) {
        this.project = project
    }

    Build getBuild() {
        return build
    }

    void setBuild(Build build) {
        this.build = build
    }
}

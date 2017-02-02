package com.diegog.amibuilder.domain

import javax.persistence.*
import javax.validation.constraints.*

/**
 * Author: dgutierrez
 * Project entity this represents amis in the ami-builder application
 */
@Entity
@Table(name = "Amis")
class Ami {

    // Fields //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private long id

    @Column(name = "baked_ami_id", length = 100)
    private String bakedAmiId

    @Column(name = "base_ami_id", nullable = false, length = 100)
    @NotNull
    private String baseAmiId

    @Column(name = "ami_status", nullable = false, length = 120)
    @NotNull
    private String amiStatus

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "build_id")
    private Build build

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = "project_id")
    private Project project

    // Methods //
    // Constructor(s)
    public Ami() { }

    public Ami(String baseAmiId, Build build, Project project) {
        this.baseAmiId = baseAmiId
        this.build = build
        this.project = project

        this.bakedAmiId = null
        this.amiStatus = "building"
    }

    // Getters and Setters
    long getId() {
        return id
    }

    String getBakedAmiId() {
        return bakedAmiId
    }

    void setBakedAmiId(String bakedAmiId) {
        this.bakedAmiId = bakedAmiId
    }

    String getBaseAmiId() {
        return baseAmiId
    }

    void setBaseAmiId(String baseAmiId) {
        this.baseAmiId = baseAmiId
    }

    String getAmiStatus() {
        return amiStatus
    }

    void setAmiStatus(String amiStatus) {
        this.amiStatus = amiStatus
    }

    Build getBuild() {
        return build
    }

    void setBuild(Build build) {
        this.build = build
    }

    Project getProject() {
        return project
    }

    void setProject(Project project) {
        this.project = project
    }
}

package com.diegog.amibuilder.domain


import javax.persistence.*
import javax.validation.constraints.*

/**
 * Author: dgutierrez
 * Project entity this represents builds in the ami-builder application
 */
@Entity
@Table(name = "Builds")
class Build {

    // Fields //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private long id

    @Column(name = "build_date", nullable = false)
    @NotNull
    private Date date

    @Column(name = "build_status", nullable = false, length = 120)
    @NotNull
    private String status

    @Column(name = "build_type", nullable = false, length = 120)
    @NotNull
    private String type

    @Column(name = "promoted", nullable = false)
    @NotNull
    private boolean promoted

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ami_id")
    private Ami ami

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = "project_id")
    private Project project

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = "job_id")
    private BuildJob buildJob

    @OneToMany(mappedBy = "build", cascade = CascadeType.ALL)
    private Set<Environment> environments

    // Methods //
    // Constructor(s)
    public Build() { }

    public Build (Date date, String type, Project project, BuildJob buildJob) {
        this.date = date
        this.type = type

        this.project = project
        this.buildJob = buildJob

        this.status = "in progress"
        this.promoted = false
        this.ami = null

        this.environments = Collections.<Environment>emptySet()
    }


    // Getters and Setters
    long getId() {
        return id
    }

    Date getDate() {
        return date
    }

    void setDate(Date date) {
        this.date = date
    }

    String getStatus() {
        return status
    }

    void setStatus(String status) {
        this.status = status
    }

    String getType() {
        return type
    }

    void setType(String type) {
        this.type = type
    }

    boolean getPromoted() {
        return promoted
    }

    void setPromoted(boolean promoted) {
        this.promoted = promoted
    }

    Ami getAmi() {
        return ami
    }

    void setAmi(Ami ami) {
        this.ami = ami
    }

    Project getProject() {
        return project
    }

    void setProject(Project project) {
        this.project = project
    }

    BuildJob getBuildJob() {
        return buildJob
    }

    void setBuildJob(BuildJob buildJob) {
        this.buildJob = buildJob
    }

    Set<Environment> getEnvironments() {
        return environments
    }

    void setEnvironments(Set<Environment> environments) {
        this.environments = environments
    }
}

package com.diegog.amibuilder.domain

import javax.persistence.*
import javax.validation.constraints.*

/**
 * Author: dgutierrez
 * Project entity this represents buildjobs in the ami-builder application
 */
@Entity
@Table(name = "BuildJobs")
class BuildJob {

    // Fields //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id ")
    @NotNull
    private long id

    @Column(name = "job_name", nullable = false, length = 200)
    @NotNull
    private String name

    @Column(name = "job_description", nullable = true, length = 500)
    private String description

    @Column(name = "base_os", nullable = false, length = 200)
    @NotNull
    private String baseOs

    @Column(name = "auto_build", nullable = false)
    @NotNull
    private boolean autoBuild

    @Column(name = "last_built_base_ami_id", nullable = false, length = 100)
    @NotNull
    private String lastBaseAmi

    @Column(name = "last_build_date", nullable = true)
    private Date lastBuildDate

    @Column(name = "auto_deploy", nullable = false)
    @NotNull
    private boolean autoDeploy

    @Column(name = "keep_until_manual_delete", nullable = false)
    @NotNull
    private boolean retainTilManualDelete

    @Column(name = "build_script", nullable = false)
    @NotNull
    private String buildScript

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = "project_id")
    @NotNull
    private Project project

    @OneToMany(mappedBy = "buildJob", cascade = CascadeType.ALL)
    private Set<Build> builds

    // Methods //
    // Constructor(s)
    public BuildJob() { }

    public BuildJob (String name, String description, String baseOs, boolean autoBuild, boolean autoDeploy, boolean retainTilManualDelete, String buildScript, Project project) {
        this.name = name
        this.description = description
        this.baseOs = baseOs
        this.autoBuild = autoBuild
        this.autoDeploy = autoDeploy
        this.retainTilManualDelete = retainTilManualDelete
        this.buildScript = buildScript

        this.project = project
        this.builds = Collections.<Build>emptySet()

        this.lastBaseAmi = "N/A"
        this.lastBuildDate = null
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

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }

    String getBaseOs() {
        return baseOs
    }

    void setBaseOs(String baseOs) {
        this.baseOs = baseOs
    }

    boolean getAutoBuild() {
        return autoBuild
    }

    void setAutoBuild(boolean autoBuild) {
        this.autoBuild = autoBuild
    }

    String getLastBaseAmi() {
        return lastBaseAmi
    }

    void setLastBaseAmi(String lastBaseAmi) {
        this.lastBaseAmi = lastBaseAmi
    }

    Date getLastBuildDate() {
        return lastBuildDate
    }

    void setLastBuildDate(Date lastBuildDate) {
        this.lastBuildDate = lastBuildDate
    }

    boolean getAutoDeploy() {
        return autoDeploy
    }

    void setAutoDeploy(boolean autoDeploy) {
        this.autoDeploy = autoDeploy
    }

    boolean getRetainTilManualDelete() {
        return retainTilManualDelete
    }

    void setRetainTilManualDelete(boolean retainTilManualDelete) {
        this.retainTilManualDelete = retainTilManualDelete
    }

    String getBuildScript() {
        return buildScript
    }

    void setBuildScript(String buildScript) {
        this.buildScript = buildScript
    }

    Project getProject() {
        return project
    }

    void setProject(Project project) {
        this.project = project
    }
}

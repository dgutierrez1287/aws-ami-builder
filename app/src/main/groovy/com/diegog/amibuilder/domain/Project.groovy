package com.diegog.amibuilder.domain

import javax.persistence.*
import javax.validation.constraints.*

/**
 * Author: dgutierrez
 * Project entity this represents projects in the ami-builder application
 */
@Entity
@Table(name = "Projects")
class Project {

    // Fields //
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private long id

    @Column(name = "name", nullable = false, length = 200)
    @NotNull
    private String name

    @Column(name = "ami_retention_non_promoted", nullable = false)
    @NotNull
    private int amiNonPromotedRetention

    @Column(name = "ami_retention_promoted", nullable = false)
    @NotNull
    private int amiPromotedRetention

    @Column(name = "project_region", nullable = false, length = 200)
    @NotNull
    private String region

    @OneToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinColumn(name = "keyset_alias")
    @NotNull
    private AwsCredential awsCredential

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(name = "ProjectUsers", joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "username", referencedColumnName = "username"))
    private Set<User> users

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<BuildJob> buildJobs

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Build> builds

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Ami> amis

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Environment> environments

    // Methods //
    // Constructor(s)
    public Project() { }

    public Project(String name, int amiNonPromoted, int amiPromoted, String region, Set<User> users, AwsCredential awsCredential) {
        this.name = name
        this.amiNonPromotedRetention = amiNonPromoted
        this.amiPromotedRetention = amiPromoted
        this.region = region
        this.users = users
        this.awsCredential = awsCredential

        this.buildJobs = Collections.<BuildJob>emptySet()
        this.users = Collections.<User>emptySet()
        this.builds = Collections.<Build>emptySet()
        this.amis = Collections.<Ami>emptySet()
        this.environments = Collections.<Environment>emptySet()
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

    int getAmiNonPromotedRetention() {
        return amiNonPromotedRetention
    }

    void setAmiNonPromotedRetention(int amiNonPromotedRetention) {
        this.amiNonPromotedRetention = amiNonPromotedRetention
    }

    int getAmiPromotedRetention() {
        return amiPromotedRetention
    }

    void setAmiPromotedRetention(int amiPromotedRetention) {
        this.amiPromotedRetention = amiPromotedRetention
    }

    String getRegion() {
        return region
    }

    void setRegion(String region) {
        this.region = region
    }

    AwsCredential getAwsCredential() {
        return awsCredential
    }

    void setAwsCredential(AwsCredential awsCredential) {
        this.awsCredential = awsCredential
    }

    Set<User> getUsers() {
        return users
    }

    void setUsers(Set<User> users) {
        this.users = users
    }

    Set<BuildJob> getBuildJobs() {
        return buildJobs
    }

    void setBuildJobs(Set<BuildJob> buildJobs) {
        this.buildJobs = buildJobs
    }

    Set<Build> getBuilds() {
        return builds
    }

    void setBuilds(Set<Build> builds) {
        this.builds = builds
    }

    Set<Ami> getAmis() {
        return amis
    }

    void setAmis(Set<Ami> amis) {
        this.amis = amis
    }

    Set<Environment> getEnvironments() {
        return environments
    }

    void setEnvironments(Set<Environment> environments) {
        this.environments = environments
    }
}

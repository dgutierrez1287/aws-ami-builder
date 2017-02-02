package com.diegog.amibuilder.domain

import javax.persistence.*
import javax.validation.constraints.*

/**
 * Author: dgutierrez
 * AwsCredential entity this represents
 * IAM key sets that the application can use for any project
 */
@Entity
@Table(name = "AwsCredentials")
class AwsCredential {

    // Fields //
    @Id
    @Column(name = "alias", nullable = false, length = 200, unique = true)
    @NotNull
    private String alias

    @Column(name = "access_key", nullable = false, length = 200)
    @NotNull
    private String accessKey

    @Column(name = "secret_key", nullable = false, length = 200)
    @NotNull
    private String secretKey

    // Methods //
    // Constructor(s)
    public AwsCredential() { }

    public AwsCredential(String alias, String accessKey, String secretKey) {
        this.alias = alias
        this.accessKey = accessKey
        this.secretKey = secretKey
    }

    String getAlias() {
        return alias
    }

    void setAlias(String alias) {
        this.alias = alias
    }

    String getAccessKey() {
        return accessKey
    }

    void setAccessKey(String accessKey) {
        this.accessKey = accessKey
    }

    String getSecretKey() {
        return secretKey
    }

    void setSecretKey(String secretKey) {
        this.secretKey = secretKey
    }
}
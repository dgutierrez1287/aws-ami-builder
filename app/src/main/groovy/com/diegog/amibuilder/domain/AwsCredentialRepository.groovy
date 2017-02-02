package com.diegog.amibuilder.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Author: dgutierrez
 * JPA Repository interface for AwsCredential
 */
@Repository
interface AwsCredentialRepository extends JpaRepository<AwsCredential, String> {

    Optional<AwsCredential> findByAlias(String alias)

    List<AwsCredential> findBySecretKey(String secretKey)

    List<AwsCredential> findByAccessKey(String accessKey)
}
package com.diegog.amibuilder.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Author: dgutierrez
 * JPA Repository interface for BuildJob
 */
@Repository
interface BuildJobRepository extends JpaRepository<BuildJob, long>{

}
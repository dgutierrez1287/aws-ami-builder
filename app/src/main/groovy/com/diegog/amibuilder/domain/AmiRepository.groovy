package com.diegog.amibuilder.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Author: dgutierrez
 * JPA Repository interface for Ami
 */
@Repository
interface AmiRepository extends JpaRepository<Ami, long>{

}
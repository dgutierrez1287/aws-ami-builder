package com.diegog.amibuilder.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Author: dgutierrez
 * JPA Repository interface for User
 */
@Repository
interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username)

    List<User> findByEmail(String email)
}
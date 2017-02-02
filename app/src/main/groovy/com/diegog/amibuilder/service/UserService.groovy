package com.diegog.amibuilder.service

import com.diegog.amibuilder.domain.User

/**
 * Author: dgutierrez
 * Service interface for UserService
 */
interface UserService {

    Optional<User> getUserByUsername(String username)

    List<User> getUsersByEmail(String email)

    List<User> getAllUsers()

    User create(String username, String passwordClear, boolean isSuperUser)

    User create(String username, String email, String passwordClear, boolean isSuperUser)
}
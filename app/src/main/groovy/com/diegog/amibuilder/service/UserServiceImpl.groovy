package com.diegog.amibuilder.service

import com.diegog.amibuilder.domain.User
import com.diegog.amibuilder.domain.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

/**
 * Author: dgutierrez
 * UserService Implentation
 */
@Service
class UserServiceImpl implements UserService {

    private final UserRepository userRepository

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username))
    }

    @Override
    public List<User> getUsersByEmail(String email) {
        return userRepository.findByEmail(email)
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll()
    }

    @Override
    public User create(String username, String email, String passwordClear, boolean isSuperUser) {
        String passwordHash = new BCryptPasswordEncoder().encode(passwordClear)

        User user = new User(username, email, passwordHash, true)
        return userRepository.save(user)
    }

    @Override
    public User create(String username, String passwordClear, boolean isSuperUser) {
        String passwordHash = new BCryptPasswordEncoder().encode(passwordClear)

        User user = new User(username, passwordHash, true)
        return userRepository.save(user)
    }
}

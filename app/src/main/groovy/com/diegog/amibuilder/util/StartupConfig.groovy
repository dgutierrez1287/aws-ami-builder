package com.diegog.amibuilder.util

import com.diegog.amibuilder.domain.AwsCredential
import com.diegog.amibuilder.domain.AwsCredentialRepository
import com.diegog.amibuilder.domain.User
import com.diegog.amibuilder.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.core.env.Environment


/**
 * Author: dgutierrez
 * This will contain methods to run at startup
 */
@Component
class StartupConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass())
    private final AwsCredentialRepository awsCredentialRepository
    private final UserService userService
    private final Environment environment

    @Autowired
    public StartupConfig(AwsCredentialRepository awsCredentialRepository, UserService userService, Environment environment) {
        this.awsCredentialRepository = awsCredentialRepository
        this.userService = userService
        this.environment = environment
    }

    /**
     * defaultAwsCredSync
     * This will sync the AWS Credentials for the application with
     * the ones that are passed to the container
     */
    public void defaultAwsCredSync() {

        logger.info("Syncing default AWS Credentials")

        String envAccessKey = environment.getProperty("AWS_ACCESS_KEY")
        String envSecretKey = environment.getProperty("AWS_SECRET_KEY")

        Optional<AwsCredential> defaultAwsCredential = awsCredentialRepository.findByAlias("default")

        if (defaultAwsCredential.empty()) {
            logger.info("Default AWS Credentials not set, setting with container env credentials")

            AwsCredential awsCredential = new AwsCredential("default", envAccessKey, envSecretKey)
            awsCredentialRepository.save(awsCredential)
        }
        else {
            logger.info("Updating default AWS Credentials")

            defaultAwsCredential.get().setAccessKey(envAccessKey)
            defaultAwsCredential.get().setSecretKey(envSecretKey)

            awsCredentialRepository.save(defaultAwsCredential)
        }
    }

    /**
     * adminUserCreate
     * This will create a default admin user if it doesnt already
     * exist
     */
    public void adminUserCreate() {

        logger.info("Checking for existance of admin user")

        Optional<User> adminUser = userService.getUserByUsername("admin")

        if (adminUser.isPresent()) {

            logger.info("admin user already exists")
        }
        else {

            logger.info("admin user does not exist, creating admin user")
            userService.create("admin", "admin", true)
        }
    }
}

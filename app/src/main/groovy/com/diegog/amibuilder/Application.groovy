package com.diegog.amibuilder

import com.diegog.amibuilder.util.StartupConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Author: dgutierrez
 * main class for the ami-builder application
 */

@SpringBootApplication
public class Application {

    private final Logger logger = LoggerFactory.getLogger(this.getClass())

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args)

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args)
        context.getBean(StartupConfig.class).defaultAwsCredSync()
        context.getBean(StartupConfig.class).adminUserCreate()
    }
}
package com.project.web

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.orm.jpa.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan(["com.project.core", "com.project.web"])
@EntityScan(basePackages = ["com.project.core"])
@EnableJpaRepositories(basePackages = ["com.project.core"])
@EnableAutoConfiguration
@PropertySource("classpath:application.properties")
class Application {

    public static void main(String [] args){
        print("Main context initializer")
        SpringApplication.run(Application.class, args);
    }
}
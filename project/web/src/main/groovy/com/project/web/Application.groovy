package com.project.web

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan

import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(["com.project.core", "com.project.web"])
@EnableAutoConfiguration
class Application {

    public static void main(String [] args){
        print("Main context initializer")
        SpringApplication.rn(Application.class, args);

    }
}
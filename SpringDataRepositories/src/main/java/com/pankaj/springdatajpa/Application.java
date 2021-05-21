package com.pankaj.springdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// By default JpaRepositories are activated for all classes
// in base package annotated with SpringBoot Application
// Use @EnableJpaRepositories(<<package name>>) on configuration class
// and specify base package name to activate repositories in any other package
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

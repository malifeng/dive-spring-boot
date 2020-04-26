package com.mlf.divespringboot;

import com.apple.eawt.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;

@Slf4j
public class SpringApplicationBootstrap {

    public static void main(String[] args) {

//        SpringApplication.run(ApplicationConfiguration.class,args);

        HashSet<String> objects = new HashSet<>();
        objects.add(ApplicationConfiguration.class.getName());

        SpringApplication springApplication = new SpringApplication();

        springApplication.setSources(objects);
        ConfigurableApplicationContext context = springApplication.run(args);

//        ApplicationConfiguration bean = context.getBean(ApplicationConfiguration.class);
//        log.warn("bean: {}",bean);
    }

    @SpringBootApplication
    public static class ApplicationConfiguration{
//        private String a = "aaaaaaaaa";
    }
}



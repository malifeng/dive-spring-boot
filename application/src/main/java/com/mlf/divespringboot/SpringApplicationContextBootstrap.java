package com.mlf.divespringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;

@SpringBootApplication
@Slf4j
public class SpringApplicationContextBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        log.warn("ConfigurableApplicationContext 类型：{}",context.getClass().getName());
        context.close();

    }
}

package com.mlf.divespringboot.bootstrap;

import com.mlf.divespringboot.annotation.EnableHelloWorld;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@EnableHelloWorld
@Slf4j
public class EnableHelloWorldBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class).web(WebApplicationType.NONE).run(args);

        String helloWorld = context.getBean("helloWorld", String.class);

        log.warn("helloWorld:{}",helloWorld);
        context.close();
    }
}

package com.mlf.divespringboot.bootstrap;


import com.mlf.divespringboot.cndition.ConditionalOnSystemProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
public class ConditionalOnSystemPropertyBootstrap {


    @ConditionalOnSystemProperty(name="user.name",value = "mlf")
    @Bean
    public String helloMlf(){
        return "Hello，World 小马哥";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class).web(WebApplicationType.NONE).run(args);

        String helloWorld = context.getBean("helloMlf", String.class);
        log.warn("Hello, World {}",helloWorld);

        context.close();
    }
}

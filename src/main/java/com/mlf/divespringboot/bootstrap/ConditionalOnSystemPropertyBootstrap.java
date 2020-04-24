package com.mlf.divespringboot.bootstrap;


import com.mlf.divespringboot.cndition.ConditionalOnSystemProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@ConditionalOnSystemProperty(name="user.name",value = "mlf")
@Slf4j
public class ConditionalOnSystemPropertyBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class).web(WebApplicationType.NONE).run(args);

        context.close();
    }
}

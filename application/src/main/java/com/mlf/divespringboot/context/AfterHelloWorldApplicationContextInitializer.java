package com.mlf.divespringboot.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;


@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE )
public class AfterHelloWorldApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        log.warn("AfterHelloWorldApplicationContextInitializer.id: {}",configurableApplicationContext.getId());
    }
}

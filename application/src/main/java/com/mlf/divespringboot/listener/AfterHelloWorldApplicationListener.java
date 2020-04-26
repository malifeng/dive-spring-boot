package com.mlf.divespringboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE)
public class AfterHelloWorldApplicationListener  implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.warn("hello world,this is after Event");
    }
}

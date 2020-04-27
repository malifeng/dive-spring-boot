package com.mlf.divespringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.addApplicationListener(applicationEvent -> {
            log.warn("监听到事件:{}",applicationEvent);
        });
        context.refresh();
        context.publishEvent("发送事件1");
        context.publishEvent("发送事件2");
        context.close();
    }
}

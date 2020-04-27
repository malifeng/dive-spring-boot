package com.mlf.divespringboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

public class BeforeConfigFileApplicationListener implements SmartApplicationListener, Ordered {


    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return true;
    }

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER-1;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) applicationEvent;
            ConfigurableEnvironment environment = (
                    (ApplicationEnvironmentPreparedEvent)
                            applicationEvent).getEnvironment();
            System.out.println("Environment.getProperty:"+environment.getProperty("name"));
        }
    }
}

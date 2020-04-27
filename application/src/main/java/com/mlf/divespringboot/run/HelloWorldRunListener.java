package com.mlf.divespringboot.run;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;


@Slf4j
public class HelloWorldRunListener implements SpringApplicationRunListener {

    public HelloWorldRunListener(SpringApplication application, String[] args) {
    }

    @Override
    public void starting() {
        System.out.println("HelloWorldRunListener.starting():");
    }
}

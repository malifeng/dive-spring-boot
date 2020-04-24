package com.mlf.divespringboot.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.mlf.divespringboot.repository.MyFirstLevelRepository;


@ComponentScan(basePackages = "com.mlf.divespringboot.repository")
@Slf4j
public class RepositoryBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class).web(WebApplicationType.NONE).run(args);


        MyFirstLevelRepository myFirstLevelRepository = context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);
        log.warn("myFirstLevelRepository Bean : {}",myFirstLevelRepository);
        // 关闭上下文
        context.close();
    }
}

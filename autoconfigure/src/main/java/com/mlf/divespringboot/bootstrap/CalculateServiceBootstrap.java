package com.mlf.divespringboot.bootstrap;


import com.mlf.divespringboot.service.CalculateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.mlf.divespringboot.service")
@Slf4j
public class CalculateServiceBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);

        CalculateService calculateService = context.getBean(CalculateService.class);

        Integer sum = calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9);


        log.warn("calculateService.sum:{}",sum);
        context.close();
    }
}

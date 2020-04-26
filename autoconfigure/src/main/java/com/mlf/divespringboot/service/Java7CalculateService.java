package com.mlf.divespringboot.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("Java7")
@Service
@Slf4j
public class Java7CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        log.info("Java7CalculateService");
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum+= values[i];
        }

        return sum;
    }
}

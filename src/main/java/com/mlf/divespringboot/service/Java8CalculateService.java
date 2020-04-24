package com.mlf.divespringboot.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

@Profile("Java8")
@Service
@Slf4j
public class Java8CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {

        log.info("Java7CalculateService");

        BinaryOperator<Integer> binaryOperator = Integer::sum;

        return Stream.of(values).reduce(0,binaryOperator);
    }
}

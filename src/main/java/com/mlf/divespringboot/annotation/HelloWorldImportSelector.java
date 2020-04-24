package com.mlf.divespringboot.annotation;


import com.mlf.divespringboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}

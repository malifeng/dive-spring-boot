package com.mlf.divespringboot.annotation;



import com.mlf.divespringboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldImportSelector.class)
//@Import(HelloWorldConfiguration.class)
public @interface EnableHelloWorld {
}

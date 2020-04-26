package com.mlf.divespringboot.configuration;


import com.mlf.divespringboot.annotation.EnableHelloWorld;
import com.mlf.divespringboot.cndition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

@Configuration //spring 模式注解
@EnableHelloWorld //spring @Enable 模块装配
@ConditionalOnSystemProperty(name="user.name",value = "mlf") //spring  条件装配
public class HelloWorldAutoConfiguration {
}

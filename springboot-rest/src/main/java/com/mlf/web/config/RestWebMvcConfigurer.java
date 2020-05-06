package com.mlf.web.config;

import com.mlf.web.http.converter.properties.PropertiesHttpMessageConverter;
import com.mlf.web.method.support.PropertiesHandlerMethodArgumentResolver;
import com.mlf.web.method.support.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
public class RestWebMvcConfigurer implements WebMvcConfigurer {


    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @PostConstruct
    public void init() {
        // 添加自定义参数优先级
//        resolvers.add(0, new PropertiesHandlerMethodArgumentResolver());

        List<HandlerMethodArgumentResolver> argumentResolvers = requestMappingHandlerAdapter.getArgumentResolvers();
        List<HandlerMethodArgumentResolver> newResolvers = new ArrayList<>(argumentResolvers.size() + 1);

        newResolvers.add(new PropertiesHandlerMethodArgumentResolver());


        newResolvers.addAll(argumentResolvers);

        requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);

        // 获取当前 requestMappingHandlerAdapter 所有的Handler对象
        List<HandlerMethodReturnValueHandler> returnValueHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();

        List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>(returnValueHandlers.size() + 1);

        newHandlers.add(new PropertiesHandlerMethodReturnValueHandler());

        newHandlers.addAll(newHandlers);

        requestMappingHandlerAdapter.setCustomReturnValueHandlers(newHandlers);


    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new PropertiesHttpMessageConverter());
        converters.add(0, new PropertiesHttpMessageConverter());
    }
}

package com.mlf.web.config;

import com.mlf.web.http.converter.properties.PropertiesHttpMessageConverter;
import com.mlf.web.support.PropertiesHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
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

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new PropertiesHttpMessageConverter());
        converters.add(0, new PropertiesHttpMessageConverter());
    }
}

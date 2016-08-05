package com.pxlim.ms.config;


import com.pxlim.ms.handlers.ObservableReturnValueHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.c1.ms.routes.*"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Resource
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @PostConstruct
    public void init() {
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList(requestMappingHandlerAdapter.getReturnValueHandlers());
        handlers.add(0, observableReturnValueHandler());
        requestMappingHandlerAdapter.setReturnValueHandlers(handlers);
    }

    @Bean
    public HandlerMethodReturnValueHandler observableReturnValueHandler() {
        return new ObservableReturnValueHandler();
    }


}
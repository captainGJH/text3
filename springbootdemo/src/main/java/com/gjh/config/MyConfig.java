package com.gjh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


//@Configuration
//public class MyConfig extends WebMvcConfigurationSupport{
//
//    @Override
//    protected void addViewControllers(ViewControllerRegistry registry) {
//        //super.addViewControllers(registry);
//        registry.addViewController("/gjh").setViewName("index");
//    }
//
//    @Bean
//    public WebMvcConfigurationSupport webMvcConfigurationSupport()
//    {
//        WebMvcConfigurationSupport support= new WebMvcConfigurationSupport()
//        {
//            @Override
//            protected void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("index");
//                registry.addViewController("/index.html").setViewName("index");
//            }
//        };
//        return support;
//
//    }
//
//}

package com.course.schedule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/schedule").setViewName("schedule");
        registry.addViewController("/").setViewName("schedule");
        registry.addViewController("/schedule/add").setViewName("schedule");
        registry.addViewController("/login").setViewName("login");
    }

}
package com.peregud.travelhistorymvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.peregud.travelhistorymvc.AppConstants.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(PAGE_JOURNEY_FORM).setViewName(VIEW_JOURNEY_FORM);
    }
}

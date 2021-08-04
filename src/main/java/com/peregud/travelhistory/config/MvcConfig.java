package com.peregud.travelhistory.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.peregud.travelhistory.AppConstants.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(PAGE_JOURNEY_FORM).setViewName(VIEW_JOURNEY_FORM);
    }
}

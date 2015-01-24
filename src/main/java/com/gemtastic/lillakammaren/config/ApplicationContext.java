package com.gemtastic.lillakammaren.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author Gemtastic
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.gemtastic.lillakammaren" })
public class ApplicationContext extends WebMvcConfigurerAdapter{
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}

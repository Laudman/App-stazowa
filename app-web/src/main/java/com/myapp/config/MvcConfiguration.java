package com.myapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan(basePackages="com.myapp")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/views/**").addResourceLocations("/views/");
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
       // registry.addResourceHandler("/js/**").addResourceLocations("/js/");
       // registry.addResourceHandler("/css/**").addResourceLocations("/css/");

	}
        
	
}

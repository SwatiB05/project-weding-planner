package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProjectWedingPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWedingPlannerApplication.class, args);
	}
	@Configuration
	public class WebMvcConfiguration extends WebMvcConfigurationSupport {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport#addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry)
	 */
	@Override
	protected void addCorsMappings(CorsRegistry registry) {
	    //NOTE: servlet context set in "application.properties" is "/api" and request like "/api/session/login" resolves here to "/session/login"!
	    registry.addMapping("/**")
	        .allowedMethods("GET", "POST", "PUT", "DELETE")
	        .allowedOrigins("*")
	        .allowedHeaders("*")
	        .allowCredentials(false);
	    }
	
	}@Bean
	public WebMvcConfigurer CORSConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                    .allowedOrigins("*")
	                    .allowedHeaders("*")
	                    .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
	                    .maxAge(-1)   // add maxAge
	                    .allowCredentials(false);
	        }
	    };
	}
}

package com.busy.apis;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class ApisApplication2 implements WebMvcConfigurer {

	@Override  
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedMethods("GET","POST","PUT","DELETE", "OPTIONS")
	    .allowedHeaders( "*" )
        .allowCredentials( false )
        .exposedHeaders( "Authorization" )
		.maxAge( 3600 );
		
		
	}
	
}

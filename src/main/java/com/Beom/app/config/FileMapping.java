package com.Beom.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//***-context.xml

@Configuration
public class FileMapping implements WebMvcConfigurer {
		
	@Value("${app.upload.url}")
	private String urlPath;// /files/**
	@Value("${app.upload.base}")
	private String filePath;// D://upload/
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler(urlPath)
				.addResourceLocations(filePath);
	
	}
}

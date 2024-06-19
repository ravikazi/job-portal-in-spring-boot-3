package com.webmayura.jobportal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

/*This configuration class will map request for /photos to serve files from directory on our file system  */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    private static final String UPLOAD_DIR="photos";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //WebMvcConfigurer.super.addResourceHandlers(registry);
        exposedDirectory(UPLOAD_DIR, registry);
    }

    private void exposedDirectory(String uploadDir, ResourceHandlerRegistry registry) {
        Path path= Paths.get(uploadDir);
        registry.addResourceHandler("/"+uploadDir+"/**").addResourceLocations("file:"+path.toAbsolutePath()+"/");
    }
}

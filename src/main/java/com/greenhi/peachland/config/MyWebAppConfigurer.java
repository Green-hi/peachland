package com.greenhi.peachland.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 静态资源本地映射
 */

@PropertySource({"classpath:application-dev.properties"})
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img_user_head/**").addResourceLocations("file:/data/peachland/img_user_head/");
        registry.addResourceHandler("/img_dynamic/**").addResourceLocations("file:/data/peachland/img_dynamic/");
        registry.addResourceHandler("/course_video/**").addResourceLocations("file:/data/peachland/course_video/");
    }
}
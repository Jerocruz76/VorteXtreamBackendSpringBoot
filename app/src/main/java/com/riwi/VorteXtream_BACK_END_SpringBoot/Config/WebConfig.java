package com.riwi.VorteXtream_BACK_END_SpringBoot.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("https://vortextreaming.netlify.app/")
                .allowedMethods("GET","POST","PATCH","PUT","DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

package com.escola.gestao_escolar.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://sistema-escolar-eight.vercel.app/")  // substitua pela URL real do seu front
                .allowedMethods("*")
                .allowCredentials(true);
    }
}

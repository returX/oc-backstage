package com.oracleclub.server.config;

import com.oracleclub.server.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * springMVC的配置文件
 * 包括拦截器，过滤器等
 * @author RETURN
 * @date 2020/8/14 0:42
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowedOrigins("*");
    }
}

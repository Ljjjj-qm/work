package com.tutor.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: abc
 * @description: 拦截器配置类
 * @author: ZhangQingMin
 * @create: 2021-04-01 23:39
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //过滤的路径
                .addPathPatterns("/**")
                // 除掉哪些不过滤
                .excludePathPatterns("/loginPage")
                .excludePathPatterns("/login");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/")
                .addResourceLocations("/static/")
                .addResourceLocations("/static/**")
                .addResourceLocations("/resources/static/")
                .addResourceLocations("/resources/static/**")
                .addResourceLocations("/")
                .addResourceLocations("/**");
    }
}
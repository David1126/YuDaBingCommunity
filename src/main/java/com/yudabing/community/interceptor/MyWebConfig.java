package com.yudabing.community.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author YuBing
 * @package com.yudabing.community.interceptor
 * @create 2019-08-14 10:13
 **/
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Autowired
    private MyAuthorizationInterceptor myAuthorizationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(myAuthorizationInterceptor).excludePathPatterns("/static/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}

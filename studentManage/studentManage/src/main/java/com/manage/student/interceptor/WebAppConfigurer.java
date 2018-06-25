package com.manage.student.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author jqbai
 */
@Configuration//通过注解来表明该类是一个Spring的配置，相当于一个xml文件
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override//注册拦截器：对所有请求都拦截，但排除登陆、初始注册、用户注册、检查用户名等请求
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new RequestInterceptor()).excludePathPatterns("/login")
            .excludePathPatterns("/registInit").excludePathPatterns("/registUser").excludePathPatterns("/")
                .excludePathPatterns("/checkUsername");
        super.addInterceptors(registry);
    }
}

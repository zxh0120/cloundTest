package com.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * /**： 匹配所有路径
 * - /admin/**：匹配 /admin/ 下的所有路径
 * - /secure/*：只匹配 /secure/user，不匹配 /secure/user/info
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor
        registry.addInterceptor(new Interceptor()).
                //所有路径都被拦截
                        addPathPatterns("/**").
                //添加不拦截路径
                        excludePathPatterns(
                        "/test/noInterceptor/*",
                        "/**/*.html",            //html静态资源
                        "/**/*.js",              //js静态资源
                        "/**/*.css",             //css静态资源
                        "/**/*.woff",
                        "/**/*.ttf"
                );
    }
}

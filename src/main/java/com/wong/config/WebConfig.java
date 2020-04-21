package com.wong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import java.util.Locale;

/**
 * 配置使其可以当请求参数中携带语言参数lang时自动切换语言
 *
 */
@Configuration// 当系统启动时，就会来配置WebConfig
public class WebConfig implements WebMvcConfigurer {


    @Bean//为了让区域信息解析器生效，将区域信息解析器注册在容器中，配置加入到SpringBoot的容器中
    public LocaleResolver localeResolver(){
        /**
         * 通过定义区域信息解析器实现程序国际化
         */
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        // 设置默认语言为中文即使用_zh.properties的文件
        localeResolver.setDefaultLocale(new Locale("zh","CN"));
        return localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        // 设置参数
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}

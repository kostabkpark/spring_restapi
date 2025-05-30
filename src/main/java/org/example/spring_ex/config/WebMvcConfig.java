package org.example.spring_ex.config;

import jakarta.servlet.Filter;
import org.example.spring_ex.interceptor.LogInterceptor;
import org.example.spring_ex.interceptor.LogInterceptor2;
import org.example.spring_ex.interceptor.LoginCheckInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Bean
  Filter shallowEtagHeaderFilter() {
    return new ShallowEtagHeaderFilter();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
//    registry.addInterceptor(new LogInterceptor())
//        .addPathPatterns("/**")
//        .order(1);
//
//    registry.addInterceptor(new LogInterceptor2())
//        .addPathPatterns("/**")
//        .order(2);

//    registry.addInterceptor(new LoginCheckInterceptor())
//        .addPathPatterns("/**")
//        .order(3)
//        .excludePathPatterns("/*.ico", "/css/**", "/posts");
  }
}

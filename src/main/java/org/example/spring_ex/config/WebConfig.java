package org.example.spring_ex.config;

import org.example.spring_ex.filter.LogFilter;
import org.example.spring_ex.filter.LogFilter2;
import org.example.spring_ex.interceptor.MethodConversionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
  @Bean
  public FilterRegistrationBean logFilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new LogFilter());
    filterRegistrationBean.setOrder(1);
    filterRegistrationBean.addUrlPatterns("/api/*");
    return filterRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean logFilter2() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new LogFilter2());
    filterRegistrationBean.setOrder(2);
    filterRegistrationBean.addUrlPatterns("/api/*");
    return filterRegistrationBean;
  }

  @Bean
  public FilterRegistrationBean methodConvertFilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new MethodConversionFilter());
    filterRegistrationBean.setOrder(3);
    filterRegistrationBean.addUrlPatterns("/api/*");
    return filterRegistrationBean;
  }


}
;
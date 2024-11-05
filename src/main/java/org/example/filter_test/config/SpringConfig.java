package org.example.filter_test.config;

import org.example.filter_test.filter.LogFilter;
import org.example.filter_test.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public FilterRegistrationBean logfilterRB() {
        FilterRegistrationBean frb = new FilterRegistrationBean(new LogFilter());
        frb.addUrlPatterns("/*");
        frb.setOrder(1);
        return frb;
    }

    @Bean
    public FilterRegistrationBean loginfilterRB() {
        FilterRegistrationBean frb = new FilterRegistrationBean(new LoginFilter());
        frb.addUrlPatterns("/members/register", "/members/login", "/members/logout");
        frb.setOrder(2);
        return frb;
    }

}

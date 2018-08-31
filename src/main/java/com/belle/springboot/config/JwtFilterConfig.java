package com.belle.springboot.config;

import com.belle.springboot.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class JwtFilterConfig {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter ());
        //添加需要拦截的url
        List<String> urlPatterns = new ArrayList ();
        urlPatterns.add("/one");
        urlPatterns.add("/all");
        urlPatterns.add ("/users/all");
        registrationBean.addUrlPatterns(urlPatterns.toArray(new String[urlPatterns.size()]));
        return registrationBean;
    }
}

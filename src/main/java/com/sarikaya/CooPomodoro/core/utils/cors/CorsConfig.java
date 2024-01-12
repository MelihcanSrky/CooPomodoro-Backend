package com.sarikaya.CooPomodoro.core.utils.cors;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class CorsConfig {
    @Bean
    public FilterRegistrationBean<CustomCorsFilter> corsFilterFilterRegistration() {
        FilterRegistrationBean<CustomCorsFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomCorsFilter());
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registrationBean.addUrlPatterns("/*"); // Tüm URL pattern'leri için geçerli

        return registrationBean;
    }
}

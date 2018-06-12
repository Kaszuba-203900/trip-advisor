package com.tul.ta.config;

import com.tul.ta.client.authentication.ApiAuthentication;
import com.tul.ta.client.authentication.DefaultApiAuthentication;
import com.tul.ta.util.HttpQueryUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public ApiAuthentication apiAuthentication() {
        return new DefaultApiAuthentication();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(new SimpleClientHttpRequestFactory());
    }

    @Bean
    public HttpQueryUtils httpQueryUtils() {
        return new HttpQueryUtils();
    }
}

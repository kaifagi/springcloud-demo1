package com.example.businessui.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //ribbon 调用使用的是RestTemplate对象
    @Bean
    @LoadBalanced//负载均衡设置

    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

package com.example.demo.feignclient;

import feign.*;
import feign.codec.*;
import feign.okhttp.*;
import org.apache.http.entity.*;
import org.springframework.context.annotation.*;

import java.util.*;

@Configuration
public class CustomerClientConfiguration {

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("token", token());
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }

    private String token(){
        return new Random().nextInt() + "";
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}

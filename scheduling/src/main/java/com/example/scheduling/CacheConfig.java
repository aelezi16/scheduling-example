package com.example.scheduling;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class CacheConfig {

    @Bean
    public ConcurrentHashMap<String, Example> concurrentHashMap(){
        return new ConcurrentHashMap<>();
    }
}

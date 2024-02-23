package com.example.springcache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class CustomKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        // Implement your custom logic to generate a unique cache key
        // Example: Concatenate method name with parameters
        StringBuilder key = new StringBuilder(method.getName());
        for (Object param : params) {
            key.append("_").append(param);
        }
        return key.toString();
    }
}


package com.example.springcache.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheManagerConfig {

    // Spring Boot will use primaryCacheManager as default for all the methods until we explicitly specify our alternateCacheManager for a method
    @Primary
    @Bean("primaryCacheManager")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager() {
            @Override
            protected Cache createConcurrentMapCache(String name) {
                return new ConcurrentMapCache(
                        name,
                        CacheBuilder.newBuilder()
                                .expireAfterWrite(10, TimeUnit.SECONDS)
                                .build().asMap(),
                        false);
            }
        };
    }

    @Bean
    public CacheManager alternativeCacheManager() {
        return new ConcurrentMapCacheManager("continent");
    }
}

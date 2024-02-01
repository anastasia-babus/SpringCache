package com.example.springcache.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

//http://localhost:8080/actuator/caches
@Slf4j
@Configuration
@EnableCaching
public class CacheManagerConfig {
    @Bean
    @Primary
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.registerCustomCache("continent",
                buildCache(100, 200, 20));
        cacheManager.registerCustomCache("countries",
                buildCache(50, 100, 10));
        return cacheManager;
    }

    private Cache buildCache(
            int initialCapacity, int maximumSize, int durationInSeconds) {
        return Caffeine.newBuilder()
                .initialCapacity(initialCapacity)
                .maximumSize(maximumSize)
                .expireAfterWrite(durationInSeconds, TimeUnit.SECONDS)
                .evictionListener((Object key, Object value, RemovalCause cause) ->
                        log.info("Key {} was evicted. Reason: {}", key, cause))
                .removalListener((Object key, Object value, RemovalCause cause) ->
                        log.info("Key {} was removed. Reason: {}", key, cause))
                .build();
    }

    @Bean
    public CacheManager idContinentCacheManager() {
        return new ConcurrentMapCacheManager("id-continent");
    }
}

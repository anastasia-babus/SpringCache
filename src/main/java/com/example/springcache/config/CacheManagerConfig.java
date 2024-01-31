package com.example.springcache.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableCaching
public class CacheManagerConfig {
//
//    @Bean
//    public CacheManager cacheManager(Caffeine caffeine) {
//        CaffeineCacheManager cacheManager = new CaffeineCacheManager("continent"); // Define your cache names here
//        cacheManager.setCaffeine(caffeine);
//
//        return cacheManager;
//    }
//
//    @Bean
//    Caffeine caffeineSpec() {
//        return Caffeine.newBuilder()
//                .initialCapacity(10)
//                .maximumSize(100)
//                .expireAfterWrite(10, TimeUnit.SECONDS);
//    }

//    @Bean
//    public CacheManager cacheManager() {
//        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
//        cacheManager.registerCustomCache("continent",
//                buildCache(100,200, 20));
//        cacheManager.registerCustomCache("countries",
//                buildCache(50,100, 10));
//        return cacheManager;
//    }
//
//    private Cache buildCache(
//            int initialCapacity, int maximumSize, int durationInSeconds) {
//        return Caffeine.newBuilder()
//                .initialCapacity(initialCapacity)
//                .maximumSize(maximumSize)
//                // .expireAfterAccess(durationInSeconds, TimeUnit.SECONDS)
//                .expireAfterWrite(durationInSeconds, TimeUnit.SECONDS)
//                .evictionListener((Object key, Object value, RemovalCause cause) ->
//                        log.info("Key {} was evicted. Reason: {}", key, cause))
//                .removalListener((Object key, Object value, RemovalCause cause) ->
//                        log.info("Key {} was removed. Reason: {}", key, cause))
//                .build();
//    }
}

package com.example.springcache.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheManagerConfig {

    //custom cache manager that will expire cache after 10 seconds after write operation, 20 sec after access
//    @Bean("customCacheManager")
//    public CacheManager cacheManager() {
//        return new ConcurrentMapCacheManager() {
//            @Override
//            protected Cache createConcurrentMapCache(String name) {
//                return new ConcurrentMapCache(
//                        name,
//                        CacheBuilder.newBuilder()
//                                .expireAfterWrite(10, TimeUnit.SECONDS)
//                                //.expireAfterAccess(20, TimeUnit.SECONDS)
//                                .build().asMap(),
//                        false);
//            }
//        };
//    }
}

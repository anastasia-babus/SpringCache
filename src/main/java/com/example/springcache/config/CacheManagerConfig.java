package com.example.springcache.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheManagerConfig {

//    @Bean
//    @Primary
//    public RedisCacheManager redisCacheManager(LettuceConnectionFactory lettuceConnectionFactory) {
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .disableCachingNullValues()
//                .entryTtl(Duration.ofMinutes(1))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
//        redisCacheConfiguration.usePrefix();
//
//        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(lettuceConnectionFactory)
//                .cacheDefaults(redisCacheConfiguration).build();
//
//    }
//    @Bean
//    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
//        return (builder) -> builder
//                .withCacheConfiguration("userCustomCache",
//                        RedisCacheConfiguration
//                                .defaultCacheConfig()
//                                .entryTtl(Duration.ofSeconds(5))
//                                .disableCachingNullValues());
//    }
//
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


//    @Bean
//    public CacheManager noOpCacheManager() {
//        return new NoOpCacheManager();
//    }

}

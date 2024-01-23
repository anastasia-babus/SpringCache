package com.example.springcache.service;

import com.example.springcache.dao.CacheRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CacheService {

    private final CacheRepository cacheRepository;

    @Cacheable("data")
    public String getData() {
        return cacheRepository.getData();
    }
    @CachePut("data")
    public String getAndUpdateData() {
        return cacheRepository.getData();
    }

    @CacheEvict(cacheNames = "data", allEntries = true)
    public void cleanAllData(){
        log.info("Cache data is cleaned");
    }

}

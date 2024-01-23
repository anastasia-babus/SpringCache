package com.example.springcache.service;

import com.example.springcache.dao.CacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CacheService {

    private final CacheRepository cacheRepository;

    public String getData(){
        return cacheRepository.getData();
    }

}

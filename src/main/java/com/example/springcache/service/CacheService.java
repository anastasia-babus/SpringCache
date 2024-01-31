package com.example.springcache.service;

import com.example.springcache.repository.CacheRepository;
import com.example.springcache.repository.Country;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@CacheConfig(cacheNames = "countries")
public class CacheService {

    private final CacheRepository cacheRepository;

    private final CacheManager customCacheManager;

    @Cacheable
    public List<String> getData() {
        return cacheRepository.getAllCountries();
    }

    @Cacheable(value = "continent")
    public String getContinent(String countryName) {
        return cacheRepository.getContinentByCountryName(countryName);
    }

    @Cacheable(cacheNames = "id-continent", key = "#id")
    public Country getCountryByContinentAndId(Integer id, String continent) {
        return cacheRepository.getContinentByIdAndContinent(id, continent);
    }

    @CacheEvict(allEntries = true)
    public void cleanAllData() {
        log.info("Cache data is cleaned");
    }

    public void cacheManager() {
        log.info("Cache names: {}", customCacheManager.getCacheNames());
    }

}

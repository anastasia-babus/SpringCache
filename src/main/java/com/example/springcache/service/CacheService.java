package com.example.springcache.service;

import com.example.springcache.repository.CacheRepository;
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

    private final CacheManager cacheManager;

    @Cacheable
    public List<String> getData() {
        return cacheRepository.getAllCountries();
    }

    @Cacheable(value = "continent",
            key = "#countryName"

            // condition = "#countryName=='USA' || #countryName=='Brazil'"
            //condition = "#result != null"
            //condition = "#result != null and #result.length() > 6"
            // unless = "#countryName=='USA'"
            //same as
            // condition = "!(#countryName=='USA')"
    )
    public String getContinent(String countryName) {
        return cacheRepository.getContinentByCountryName(countryName);
    }

    @CacheEvict(allEntries = true)
    public void cleanAllData() {
        log.info("Cache data is cleaned");
    }

    public void cacheManager() {
        log.info("Cache names: {}", cacheManager.getCacheNames());
    }

}

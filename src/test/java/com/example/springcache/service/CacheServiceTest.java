package com.example.springcache.service;

import com.example.springcache.repository.CacheRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CacheServiceTest {

    @MockBean
    private CacheRepository cacheRepository;

    @Autowired
    private CacheService cacheService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testCachedData() {
        String countryName = "USA";
        when(cacheRepository.getContinentByCountryName(countryName)).thenReturn("North America");

        // Initial invocation
        String result1 = cacheService.getContinent(countryName);

        // Check if result is cached
        Cache cache = cacheManager.getCache("continent");
        assertNotNull(cache);
        assertNotNull(cache.get(countryName));

        // Subsequent invocation - should be retrieved from the cache
        when(cacheRepository.getContinentByCountryName(countryName)).thenReturn("America");
        String result2 = cacheService.getContinent(countryName);

        // Verify that the results match
        assertEquals(result1, result2);
    }

    @Test
    public void testEvictionPolicy() {
        // Cache some data first
        Cache evictionCache = cacheManager.getCache("countries");
        evictionCache.put("key1", "value1");
        evictionCache.put("key2", "value2");

        // Evict the cache
        cacheService.cleanAllData();

        // Verify that the cache has been evicted
        assertNull(evictionCache.get("key1"));
        assertNull(evictionCache.get("key2"));
    }
}
package com.example.springcache.service;

import com.example.springcache.repository.User;
import com.example.springcache.repository.UserCacheRepository;
import com.example.springcache.service.object.UserObj;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CacheServiceTest {

    @MockBean
    private UserCacheRepository userCacheRepository;

    @Autowired
    private UserCacheService userCacheService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testCachedData() {
        User testUser = buildUser("Jane", "Doe");
        long userId = testUser.getId();
        when(userCacheRepository.getUserById(userId)).thenReturn(testUser);

        // Initial invocation
        UserObj result1 = userCacheService.getUserById(userId);

        // Check if result is cached
        Cache cache = cacheManager.getCache("users");
        assertNotNull(cache);
        assertNotNull(cache.get(userId));

        // Subsequent invocation - should be retrieved from the cache
        when(userCacheRepository.getUserById(testUser.getId())).thenReturn(buildUser("Bob", "Johnson"));
        UserObj result2 = userCacheService.getUserById(userId);

        // Verify that the results match
        assertEquals(result1, result2);
    }

    @Test
    public void testEvictionPolicy() {
        // Cache some data first
        Cache evictionCache = cacheManager.getCache("users");
        evictionCache.put("key1", "value1");
        evictionCache.put("key2", "value2");

        // Evict the cache
        userCacheService.cleanAllData();

        // Verify that the cache has been evicted
        assertNull(evictionCache.get("key1"));
        assertNull(evictionCache.get("key2"));
    }

    private User buildUser(String firstName, String lastName) {
        User testUser = new User();
        long id = 1L;
        testUser.setId(id);
        testUser.setFirstName(firstName);
        testUser.setLastName(lastName);
        return testUser;
    }
}
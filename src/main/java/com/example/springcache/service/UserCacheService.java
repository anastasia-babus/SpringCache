package com.example.springcache.service;

import com.example.springcache.repository.UserCacheRepository;
import com.example.springcache.service.object.UserObj;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.springcache.service.object.UserObj.userObjToUser;
import static com.example.springcache.service.object.UserObj.userToUserObj;

@Slf4j
@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = "users")
public class UserCacheService {

    private final UserCacheRepository userCacheRepository;

    private final CacheManager cacheManager;

    @Cacheable
    public List<String> getAllUsers() {
        return userCacheRepository.getAllUsers();
    }

    @Cacheable
    public UserObj getUserById(Long userId) {
        return userToUserObj(userCacheRepository.getUserById(userId));
    }

    @CachePut
    public UserObj updateUser(UserObj user) {
        return userToUserObj(userCacheRepository.updateUser(userObjToUser(user)));
    }

    @Cacheable
    public UserObj getUserByFirstAndLastName(String firstName, String lastName) {
        return userToUserObj(userCacheRepository.getUserByFirstAndLastName(firstName, lastName));
    }

    @CacheEvict(allEntries = true)
    public void cleanAllData() {
        log.info("Cache data is cleaned");
    }

    public void debugCacheManager() {
        log.info(cacheManager.getCacheNames().toString());
    }

}

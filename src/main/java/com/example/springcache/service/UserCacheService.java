package com.example.springcache.service;

import com.example.springcache.repository.UserCacheRepository;
import com.example.springcache.service.object.UserObj;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
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
public class UserCacheService {

    private final UserCacheRepository userCacheRepository;

    // private final CacheManager cacheManager;

    // @Cacheable("users")
    public List<String> getAllUsers() {
        return userCacheRepository.getAllUsers();
    }

    // @Cacheable("users")
    public UserObj getUserById(Long userId) {
        return userToUserObj(userCacheRepository.getUserById(userId));
    }

    /*
    The @CachePut("data") annotation is part of the Spring Cache abstraction and is used to declare a method as
    responsible for updating the cache
     */
    //@CachePut("users")
    public UserObj updateUser(UserObj user) {
        return userToUserObj(userCacheRepository.updateUser(userObjToUser(user)));
    }

    @Cacheable("users")
    public UserObj getUserByFirstAndLastName(String firstName, String lastName) {
        return userToUserObj(userCacheRepository.getUserByFirstAndLastName(firstName, lastName));
    }

    /*
    Annotation indicating that a method (or all methods on a class) triggers a cache evict operation.
    allEntries indicates whether all the entries inside the cache(s) are removed. By default, only the value under the associated key is removed.
     */
    // @CacheEvict(cacheNames = "users", allEntries = true)
    public void cleanAllData() {
        log.info("Cache data is cleaned");
    }

    public void debugCacheManager() {
        // log.info(cacheManager.getCacheNames().toString());
    }

}

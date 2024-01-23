package com.example.springcache.service;

import com.example.springcache.repository.UserCacheRepository;
import com.example.springcache.service.object.UserObj;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.springcache.service.object.UserObj.userObjToUser;
import static com.example.springcache.service.object.UserObj.userToUserObj;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserCacheService {

    private final UserCacheRepository userCacheRepository;

    public List<String> getAllUsers() {
        return userCacheRepository.getAllUsers();
    }

    public UserObj getUserById(Long userId) {
        return userToUserObj(userCacheRepository.getUserById(userId));
    }

    public UserObj updateUser(UserObj user) {
        return userToUserObj(userCacheRepository.updateUser(userObjToUser(user)));
    }
    public UserObj getUserByFirstAndLastName(String firstName, String lastName) {
        return userToUserObj(userCacheRepository.getUserByFirstAndLastName(firstName, lastName));
    }

}

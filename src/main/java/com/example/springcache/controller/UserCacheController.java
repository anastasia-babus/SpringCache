package com.example.springcache.controller;

import com.example.springcache.service.UserCacheService;
import com.example.springcache.service.object.UserObj;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserCacheController {

    private final UserCacheService userCacheService;

    @GetMapping("/all-users")
    public List<String> getAllUsers() {
        return userCacheService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public UserObj getUserById(@PathVariable("userId") Long userId) {
        return userCacheService.getUserById(userId);
    }

    @PutMapping("/user")
    public UserObj getContinentByCountryName(@RequestBody UserObj user) {
        return userCacheService.updateUser(user);
    }

    @GetMapping("/user")
    public UserObj getUserByFirstAndLastName(@RequestParam("firstName") String firstName,
                                             @RequestParam("lastName") String lastName) {
        return userCacheService.getUserByFirstAndLastName(firstName, lastName);
    }

}

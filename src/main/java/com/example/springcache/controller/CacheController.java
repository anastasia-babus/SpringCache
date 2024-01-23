package com.example.springcache.controller;

import com.example.springcache.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CacheController {

    private final CacheService cacheService;

    @GetMapping("/data")
    public String getData() {
        return cacheService.getData();
    }

    @GetMapping("/refreshData")
    public String getAndUpdateData() {
        return cacheService.getAndUpdateData();
    }

    @GetMapping("/evict")
    public void cleanAllData() {
        cacheService.cleanAllData();
    }
}

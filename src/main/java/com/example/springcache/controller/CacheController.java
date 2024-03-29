package com.example.springcache.controller;

import com.example.springcache.repository.Country;
import com.example.springcache.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CacheController {

    private final CacheService cacheService;

    @GetMapping("/data")
    public List<String> getAllCountries() {
        return cacheService.getData();
    }
    @GetMapping("/continent")
    public String getContinentByCountryName(@RequestParam("countryName") String countryName) {
        return cacheService.getContinent(countryName);
    }

    @GetMapping("/id-continent")
    public Country getCountryByIdAndContinent(@RequestParam("id") Integer id, @RequestParam("continent") String continent) {
        return cacheService.getCountryByContinentAndId(id, continent);
    }

    @GetMapping("/evict")
    public void cleanAllData() {
        cacheService.cleanAllData();
    }

    @GetMapping("/cache-names")
    public void logCacheNames() {
        cacheService.cacheManager();
    }
}

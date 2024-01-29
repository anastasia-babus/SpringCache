package com.example.springcache.repository;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class CacheRepository {

    private final CountriesRepository countriesRepository;

    @SneakyThrows
    public List<String> getAllCountries(){
        Thread.sleep(2000L);
        return countriesRepository.findAll().stream()
                .map(Country::getName)
                .toList();
    }

    @SneakyThrows
    public String getContinentByCountryName(String countryName){
        Thread.sleep(2000L);
        return countriesRepository.findCountryByName(countryName).map(Country::getContinent).orElse("No such country");
    }

    @SneakyThrows
    public Country getContinentByIdAndContinent(Integer id, String continentName) {
        Thread.sleep(2000L);
        return countriesRepository.findCountryByIdAndContinent(id, continentName).orElseThrow(NoSuchElementException::new);
    }

}

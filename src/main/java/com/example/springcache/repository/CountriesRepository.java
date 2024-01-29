package com.example.springcache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountriesRepository extends JpaRepository<Country, Integer> {

    List<Country> findAll();

    Optional<Country> findCountryByName(String countryName);

    Optional<Country> findCountryByIdAndContinent(Integer id, String continent);
}

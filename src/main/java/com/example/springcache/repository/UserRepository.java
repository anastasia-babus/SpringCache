package com.example.springcache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAll();

    Optional<User> getUserById(Long id);

    Optional<User> getUserByFirstNameAndLastName(String firstName, String lastName);
}

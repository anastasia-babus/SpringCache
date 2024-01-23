package com.example.springcache.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class UserCacheRepository {

    @Value("${connection.delay}")
    private int connectionDelay;

    private final UserRepository userRepository;

    @Transactional
    public User updateUser(User user){
        User userFromDb = userRepository.getUserById(user.getId()).orElseThrow(() -> new NoSuchElementException("No such user"));
        userFromDb.setFirstName(user.getFirstName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setAddress(user.getAddress());
        userFromDb.setDateOfBirth(user.getDateOfBirth());
        userRepository.save(user);
        return user;
    }

    @SneakyThrows
    public List<String> getAllUsers() {
        Thread.sleep(connectionDelay);
        return userRepository.findAll().stream()
                .map(user -> user.getFirstName() + " " + user.getLastName())
                .toList();
    }

    @SneakyThrows
    public User getUserById(Long id) {
        Thread.sleep(connectionDelay);
        return userRepository.getUserById(id).orElseThrow(() -> new NoSuchElementException("No such user"));
    }

    @SneakyThrows
    public User getUserByFirstAndLastName(String firstName, String lastName) {
        Thread.sleep(connectionDelay);
        return userRepository.getUserByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new NoSuchElementException("No such user"));
    }
}

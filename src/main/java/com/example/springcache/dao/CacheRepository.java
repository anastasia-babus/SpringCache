package com.example.springcache.dao;

import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.nio.file.Path;

@Repository
public class CacheRepository {

    @SneakyThrows
    public String getData(){
        Thread.sleep(2000L);
        return Files.readString(Path.of("src/main/resources/testData"));
    }
}

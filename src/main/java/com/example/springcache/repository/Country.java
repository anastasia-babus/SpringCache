package com.example.springcache.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="countries")
@Entity
public class Country {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "continent")
    private String continent;

    //millions
    @Column(name = "population")
    private int population;

}

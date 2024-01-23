package com.example.springcache.repository;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="users")
@Entity
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "address")
    private String address;

}

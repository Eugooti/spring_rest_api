package com.eugooti.restapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String access;

    @Column(unique = true , nullable = false) // Add this annotation to make emailAddress unique
    private String emailAddress;

    @Column(nullable = false)
    private String PhoneNumber;

    @Column(nullable = false)
    private String password;
}

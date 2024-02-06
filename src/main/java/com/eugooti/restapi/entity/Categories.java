package com.eugooti.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Categories {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private int maximumCost;
    private String createdBy;
}

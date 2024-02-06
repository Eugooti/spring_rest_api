package com.eugooti.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Expenditure {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String category;
    private int cost;
    private String description;
    private String createdBy;
}

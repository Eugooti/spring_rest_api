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
@Table(name = "calendar")
public class Calendar {

    @Id
    @GeneratedValue
    private int id;
    private String event;
    private String description;
    private String start;
    private String end;
    private String createdBy;

}

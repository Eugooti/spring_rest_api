package com.eugooti.restapi.repository;

import com.eugooti.restapi.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Categories,Integer> {
    List<Categories> findByCreatedBy(String user);
}

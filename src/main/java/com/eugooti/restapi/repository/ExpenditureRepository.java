package com.eugooti.restapi.repository;

import com.eugooti.restapi.entity.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenditureRepository extends JpaRepository<Expenditure,Integer> {
    List<Expenditure> findByCreatedBy(String user);
}

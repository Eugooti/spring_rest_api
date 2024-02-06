package com.eugooti.restapi.repository;

import com.eugooti.restapi.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo,Integer> {
    List<ToDo> findByCreatedBy(String user);
}

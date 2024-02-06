package com.eugooti.restapi.repository;

import com.eugooti.restapi.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarRepository extends JpaRepository<Calendar,Integer> {
    List<Calendar> findByCreatedBy(String user);
}

package com.eugooti.restapi.repository;

import com.eugooti.restapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}

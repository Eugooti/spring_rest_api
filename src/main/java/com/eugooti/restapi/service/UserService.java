package com.eugooti.restapi.service;

import com.eugooti.restapi.entity.User;
import com.eugooti.restapi.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public User createUser(User user){
        String hashedPassword= BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());

        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


}

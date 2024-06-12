package com.codewitharjun.fullstackbackend.service;

import com.codewitharjun.fullstackbackend.model.User;
import com.codewitharjun.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public String saveuser (User newUser){
        User user1 = userRepository.findByEmail(newUser.getEmail());
        if(user1==null) {
            userRepository.save(newUser);
            return "true";
        }else return "false";
    }
}

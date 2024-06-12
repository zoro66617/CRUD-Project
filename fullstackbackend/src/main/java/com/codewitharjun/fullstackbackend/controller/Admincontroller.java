package com.codewitharjun.fullstackbackend.controller;

import com.codewitharjun.fullstackbackend.DTO.AdminDTO;
import com.codewitharjun.fullstackbackend.model.Admin;
import com.codewitharjun.fullstackbackend.model.User;
import com.codewitharjun.fullstackbackend.repository.UserRepository;
import com.codewitharjun.fullstackbackend.service.AdminService;
import com.codewitharjun.fullstackbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Admincontroller {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminService adminService;
    @PostMapping("/createAdmin")
    String newAdmin(@RequestBody Admin newUser){
        return adminService.saveAdmin(newUser);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/loginAdmin")
    String loginAdmin(@RequestBody AdminDTO admin) {
        return adminService.loginAdmin(admin);
    }

}

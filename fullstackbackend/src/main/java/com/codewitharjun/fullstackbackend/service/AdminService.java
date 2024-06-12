package com.codewitharjun.fullstackbackend.service;

import com.codewitharjun.fullstackbackend.DTO.AdminDTO;
import com.codewitharjun.fullstackbackend.model.Admin;
import com.codewitharjun.fullstackbackend.repository.Adminrep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminService {
    @Autowired
    private Adminrep adminrep;
    public String saveAdmin (Admin newAdmin){
        Admin admin1 = adminrep.findByEmail(newAdmin.getEmail());
        if(admin1==null) {
            adminrep.save(newAdmin);
            return "true";
        }else return "false";
    }
    public String loginAdmin(AdminDTO newAdmin){
        Admin admin1 = adminrep.findByEmail(newAdmin.getEmail());
        if(admin1==null){
            return "sorry you email is incorrect or not exist";
        }else{
            if(Objects.equals(admin1.getPassword(), newAdmin.getPassword())){
                return "valid";
            }else {
                return "sorry your password is incorrect";
            }

        }

    }
}

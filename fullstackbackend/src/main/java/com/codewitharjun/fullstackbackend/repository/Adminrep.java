package com.codewitharjun.fullstackbackend.repository;

import com.codewitharjun.fullstackbackend.model.Admin;
import com.codewitharjun.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Adminrep extends JpaRepository<Admin,Long> {
    Admin findByEmail(String email);
}

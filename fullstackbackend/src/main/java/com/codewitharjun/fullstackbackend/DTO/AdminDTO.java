package com.codewitharjun.fullstackbackend.DTO;

import jakarta.persistence.Column;

public class AdminDTO {
    @Column(name = "password")
    private String password;
    @Column(name = "EMAIL")
    private String email;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

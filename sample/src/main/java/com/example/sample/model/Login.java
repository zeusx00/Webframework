package com.example.sample.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Login {
    @Id
    private int loginId;
    private String password;
    @OneToOne(mappedBy = "login" ,cascade=CascadeType.ALL)
    @JsonManagedReference
    NameEntity nameEntity;
    public int getLoginId() {
        return loginId;
    }
    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Login(int loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }
    public Login() {
    }
    
    
    

    
}
package com.example.sample.repository;

import com.example.sample.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login,Integer> {
    
}

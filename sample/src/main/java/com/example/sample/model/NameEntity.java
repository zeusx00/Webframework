package com.example.sample.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;  
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class NameEntity {
    
   @Id
    private int id;
    private String name;
 
    @OneToOne   
    @JsonBackReference
    Login login;

    public NameEntity(){}

    public NameEntity(int id, String name) {
        this.id=id;
        this.name = name;
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
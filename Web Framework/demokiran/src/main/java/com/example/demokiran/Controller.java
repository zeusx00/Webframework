package com.example.demokiran;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller 
{
    @GetMapping("/") 
    public String get()
    {
        return "Welcome";
    }    
}
package com.example.sample.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.model.Login;
import com.example.sample.service.LoginService;

@RestController
public class LoginController {
    @Autowired
    LoginService ls;
@PostMapping("/api/login")
    public ResponseEntity<Login> createLogin(@RequestBody Login login) {
        Login obj = ls.create(login);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @GetMapping("/api/logins")
    public ResponseEntity<List<Login>> getAllLogins() {
        List<Login> logins = ls.getAllDetails();
        return new ResponseEntity<>(logins, HttpStatus.OK);
    }

    @GetMapping("/api/login/{loginId}")
    public ResponseEntity<Login> getLoginById(@PathVariable Integer loginId) {
        Login login = ls.getLoginById(loginId);
        return new ResponseEntity<>(login, HttpStatus.OK);    
    }

    @PutMapping("api/login/{loginId}")
    public ResponseEntity<Login> updateProductsController(@PathVariable int loginId, @RequestBody Login pe)
    {
        if(ls.updateDetails(loginId, pe)==true)
            return new ResponseEntity<>(pe, HttpStatus.OK);
        else
            return new ResponseEntity<>(pe,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("api/login/{loginId}")
    public ResponseEntity<Boolean> deleteProductsController(@PathVariable int loginId)
    {
        if(ls.deleteLogin(loginId)==true)
            return new ResponseEntity<>(true,HttpStatus.OK);
        else
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
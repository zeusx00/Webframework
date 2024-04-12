package com.example.sample.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sample.model.Login;
import com.example.sample.repository.LoginRepo;

@Service
public class LoginService {

    @Autowired
    LoginRepo lr;

    public Login create(Login le)
    {
        return lr.save(le);
    }

    public List<Login> getAllDetails(){
        return lr.findAll();
    }

    public Login getLoginById(int loginId)
    {
        return lr.findById(loginId).orElse(null);
    }
    public boolean updateDetails(int id,Login login)
        {
            if(this.getLoginById(id)==null)
            {
                return false;
            }
            try{
                lr.save(login);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }
public boolean deleteLogin(int id)
        {
            if(this.getLoginById(id) == null)
            {
                return false;
            }
            lr.deleteById(id);
            return true;
        }

}
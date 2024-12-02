package com.example.ecomwebproject.Service;

import com.example.ecomwebproject.Model.Users;
import com.example.ecomwebproject.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo repo;


    public Boolean createuser(Users u1) {

//        if(repo.findByName(u1.getName()))
//        {
//            System.out.println("User already exists with same name ");
//            return false;
//        }

//        else
        {
            repo.save(u1);
        }
        return true;
    }
}

package com.example.ecomwebproject.Repo;

import com.example.ecomwebproject.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    //boolean findByName(String name);
}

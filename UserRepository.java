package com.examer.examnow.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.examer.examnow.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);

  
}
package com.examer.examnow.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examer.examnow.model.User;
import com.examer.examnow.repo.UserRepository;
@Service
public class UserDetailServiceimpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user =this.userRepository.findByUsername(username);
       if(user==null){
        System.out.println("User not Found");
        throw new UsernameNotFoundException("NO User Found");

       }


        return user;
    }
   
 

    
}
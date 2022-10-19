package com.examer.examnow.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examer.examnow.service.UserService;
import com.examer.examnow.model.User;
import com.examer.examnow.model.Role;
import com.examer.examnow.model.UserRole;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /// creating user
    @PostMapping("/")
    public User creatUser(@RequestBody User user) throws Exception{
        //encoding password with bcryptpswrdencoder
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("Normal");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
     
        roles.add(userRole);
        return this.userService.createUser(user, roles);


    }
    // GETTING USER BY USER NAME
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }
    // delete user by user Id
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);

    }
}
package com.examer.examnow.service;

import java.util.Set;

import com.examer.examnow.model.User;
import com.examer.examnow.model.UserRole;

public interface UserService {
    // creating the user here is the strarting
    public User createUser(User user,Set<UserRole> UserRoles) throws Exception;
    /// get user by user name
    public User getUser(String username);
    // delete user by id
    public void deleteUser(Long userId);
}
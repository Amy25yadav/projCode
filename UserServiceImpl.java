package com.examer.examnow.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examer.examnow.service.UserService;
import com.examer.examnow.model.User;
import com.examer.examnow.model.UserRole;
import com.examer.examnow.repo.RoleRepository;
import com.examer.examnow.repo.UserRepository;
@Service                   
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    ////////// CREATING USER ///
    @Override
    public User createUser(User user, Set<UserRole> UserRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("user is alredy there");
            throw new Exception("user is alredy present");
        } else {
            // user create karna
            for (UserRole ur : UserRoles) {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(UserRoles);
            local = this.userRepository.save(user);

        }

        return local;

    }
//// gettting user by username
    @Override
    public User getUser(String username) {
        
        return this.userRepository.findByUsername(username);
    }
    @Override
    public void deleteUser(Long userId) {
       this.userRepository.deleteById(userId);
    }
   
}

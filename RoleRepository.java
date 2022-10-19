package com.examer.examnow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examer.examnow.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    
}

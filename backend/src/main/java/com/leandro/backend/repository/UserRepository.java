package com.leandro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    

}

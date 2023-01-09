package com.leandro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, String> {
    
}

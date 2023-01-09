package com.leandro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String>{
    
}

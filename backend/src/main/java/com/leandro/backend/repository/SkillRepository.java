package com.leandro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, String>{
    
}

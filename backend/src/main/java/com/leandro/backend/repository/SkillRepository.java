package com.leandro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, String>{
    
    @Modifying
    @Query("update Skill s set s.id_user = :id_user where s.id = :id")
    String updateIdUser(@Param(value = "id") String id,
                        @Param(value = "id_user") String idUser);

    @Modifying
    @Query("update Skill s set s.skill_name = :skill_name where s.id = :id")
    String updateSkillName(@Param(value = "id") String id,
                           @Param(value = "skill_name") String skillName);

    @Modifying
    @Query("update Skill s set s.percentage = :percentage where s.id = :id")
    String updatePercentage(@Param(value = "id") String id,
                            @Param(value = "percentage") String percentage);

}

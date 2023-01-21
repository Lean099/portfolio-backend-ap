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
    @Query("update Skill s set s.idUser = :idUser where s.id = :id")
    void updateIdUser(@Param(value = "id") String id,
                      @Param(value = "idUser") String idUser);

    @Modifying
    @Query("update Skill s set s.skillName = :skillName where s.id = :id")
    void updateSkillName(@Param(value = "id") String id,
                         @Param(value = "skillName") String skillName);

    @Modifying
    @Query("update Skill s set s.percentage = :percentage where s.id = :id")
    void updatePercentage(@Param(value = "id") String id,
                          @Param(value = "percentage") String percentage);

}

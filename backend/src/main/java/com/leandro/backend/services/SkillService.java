package com.leandro.backend.services;

import java.util.List;

import com.leandro.backend.models.Skill;

public interface SkillService {
    
    Skill saveSkill(Skill skill, String idUser);
    Skill getSkill(String idSkill);
    List<Skill> getAllUserSkill(String idUser);
    String deleteSkill(String idSkill);
    String deleteAllUserSkill(String idUser);
    void updateIdUser(String id, String idUser);
    void updateSkillName(String id, String skillName);
    void updatePercentage(String id, int percentage);

}

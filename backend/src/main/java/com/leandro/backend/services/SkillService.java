package com.leandro.backend.services;

import java.util.List;

import com.leandro.backend.models.Skill;
import com.leandro.backend.models.User;

public interface SkillService {
    
    Skill saveSkill(Skill skill, String idUser);
    Skill getSkill(String idSkill);
    List<Skill> getAllUserSkill(User idUser);
    String deleteSkill(String idSkill);
    String deleteAllUserSkill(User idUser);
    void updateIdUser(String id, String idUser);
    void updateSkillName(String id, String skillName);
    void updatePercentage(String id, int percentage);

}

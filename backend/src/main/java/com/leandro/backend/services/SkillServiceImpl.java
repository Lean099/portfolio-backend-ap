package com.leandro.backend.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.leandro.backend.models.Skill;
import com.leandro.backend.models.User;
import com.leandro.backend.repository.SkillRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
public class SkillServiceImpl implements SkillService{
    
    private final SkillRepository skillRepo;
    private final EntityManager entityManager;

    @Override
    public Skill saveSkill(Skill skill, String idUser) {
        skill.setIdUser(entityManager.getReference(User.class, idUser));
        return skillRepo.save(skill);
    }

    @Override
    public Skill getSkill(String idSkill) {
        return skillRepo.findById(idSkill).get();
    }

    @Override
    public List<Skill> getAllUserSkill(String idUser) {
        User user = new User();
        user.setId(idUser);
        return skillRepo.findAllByIdUser(user);
    }

    @Override
    public String deleteSkill(String idSkill) {
        skillRepo.deleteById(idSkill);
        boolean isPresent = skillRepo.existsById(idSkill);
        if(isPresent){
            return "Could not be deleted";
        }
        return "Deleted successfully";
    }

    @Override
    public String deleteAllUserSkill(String idUser) {
        skillRepo.deleteAll(getAllUserSkill(idUser));
        return "All deleted";
    }

    @Override
    public void updateIdUser(String id, String idUser) {
        skillRepo.updateIdUser(id, idUser);
    }

    @Override
    public void updateSkillName(String id, String skillName) {
        skillRepo.updateSkillName(id, skillName);
    }

    @Override
    public void updatePercentage(String id, int percentage) {
        skillRepo.updatePercentage(id, percentage);
    }

}

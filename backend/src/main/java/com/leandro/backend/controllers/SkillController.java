package com.leandro.backend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.models.Skill;
import com.leandro.backend.services.SkillService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SkillController {
    
    private final SkillService skillService;

    @RequestMapping(value = "/skill/create/{idUser}", method = RequestMethod.POST)  // Funciona
    public Skill createSkill(@PathVariable String idUser, @RequestBody Skill skill){
        return skillService.saveSkill(skill, idUser);
    }

    @RequestMapping(value = "/skill/{idSkill}", method = RequestMethod.GET)
    public Skill getSingleSkill(@PathVariable String idSkill){ // Funciona
        return skillService.getSkill(idSkill);
    }

    @RequestMapping(value = "/skill/all/{idUser}", method = RequestMethod.GET)
    public List<Skill> getAllSkill(@PathVariable String idUser){ // Funciona
        return skillService.getAllUserSkill(idUser);
    }

    @RequestMapping(value = "/skill/update/{idSkill}", method = RequestMethod.POST) // Funciona
    public Skill updateSkill(@PathVariable String idSkill, @RequestBody Skill skill){
        if(!Objects.isNull(skill.getSkillName())){
            skillService.updateSkillName(idSkill, skill.getSkillName());
        }
        if(!Objects.isNull(skill.getPercentage())){
            skillService.updatePercentage(idSkill, skill.getPercentage());
        }
        return skillService.getSkill(idSkill);
    }

    @RequestMapping(value = "/skill/delete/{idSkill}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSkill(@PathVariable String idSkill){ // Funciona
        String message = skillService.deleteSkill(idSkill);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", "Resource with ID " + idSkill +  " " + message);
        return ResponseEntity.ok().body(responseMap);
    }

}

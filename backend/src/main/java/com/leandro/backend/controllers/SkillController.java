package com.leandro.backend.controllers;

import java.util.List;

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

    @RequestMapping(value = "/skill/create", method = RequestMethod.POST)
    public Skill createSkill(@RequestBody Skill skill){
        return null;
    }

    @RequestMapping(value = "/skill/{idSkill}", method = RequestMethod.GET)
    public Skill getSingleSkill(@PathVariable String idSkill){
        return null;
    }

    @RequestMapping(value = "/skill/{idUser}", method = RequestMethod.GET)
    public List<Skill> getAllSkill(@PathVariable String idUser){
        return null;
    }

}

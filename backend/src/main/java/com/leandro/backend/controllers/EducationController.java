package com.leandro.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.models.Education;
import com.leandro.backend.services.EducationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @RequestMapping(value = "/education/create", method = RequestMethod.POST)
    public Education createEducation(@RequestBody Education education){
        return null;
    }

    @RequestMapping(value = "/education/{idEducation}", method = RequestMethod.POST)
    public Education getSingleEducation(@PathVariable String idEducation){
        return null;
    }

    @RequestMapping(value = "/education/all/{idUser}", method = RequestMethod.POST)
    public List<Education> getAllEducation(@PathVariable String idUser){
        return null;
    }
    
}

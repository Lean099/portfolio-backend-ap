package com.leandro.backend.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.models.Education;
import com.leandro.backend.models.User;
import com.leandro.backend.services.EducationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @RequestMapping(value = "/education/create/{idUser}", method = RequestMethod.POST) // Funciona
    public Education createEducation(@PathVariable String idUser, @RequestBody Education education){
        return educationService.saveEducation(education, idUser);
    }

    @RequestMapping(value = "/education/{idEducation}", method = RequestMethod.GET)
    public Education getSingleEducation(@PathVariable String idEducation){ // Funciona
        return educationService.getSingleEducation(idEducation);
    }

    @RequestMapping(value = "/education/all", method = RequestMethod.GET)
    public List<Education> getAllEducation(@RequestBody User idUser){ // Funciona
        return educationService.getAllUserEducation(idUser);
    }

    @RequestMapping(value = "/education/update/{idEducation}", method = RequestMethod.POST) // Funciona
    public Education updateEducation(@PathVariable String idEducation, @RequestBody Education education){
        if(!Objects.isNull(education.getInstitution())){
            educationService.updateInstitution(idEducation, education.getInstitution());
        }
        if(!Objects.isNull(education.getDegree())){
            educationService.updateDegree(idEducation, education.getDegree());
        }
        if(!Objects.isNull(education.getEnddate())){
            educationService.updateEnddate(idEducation, education.getEnddate());
        }
        return educationService.getSingleEducation(idEducation);
    }

    @RequestMapping(value = "/education/delete/{idEducation}", method = RequestMethod.DELETE)
    public String deleteEducation(@PathVariable String idEducation){ // Funciona
        return educationService.deleteEducation(idEducation);
    }
    
}

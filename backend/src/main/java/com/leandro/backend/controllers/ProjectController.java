package com.leandro.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.models.Project;
import com.leandro.backend.services.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProjectController {
    
    private final ProjectService projectService;

    @RequestMapping(value = "/project/create", method = RequestMethod.POST)
    public Project createProject(@RequestBody Project project){
        return null;
    }

    @RequestMapping(value = "/project/{idProject}", method = RequestMethod.GET)
    public Project getSingleProject(@PathVariable String idProject){
        return null;
    }

    @RequestMapping(value = "/project/{idUser}", method = RequestMethod.GET)
    public List<Project> getAllProject(@PathVariable String idUser){
        return null;
    }

}

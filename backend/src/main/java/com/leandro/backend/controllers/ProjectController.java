package com.leandro.backend.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.models.Project;
import com.leandro.backend.models.User;
import com.leandro.backend.services.ProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProjectController {
    
    private final ProjectService projectService;

    @RequestMapping(value = "/project/create/{idUser}", method = RequestMethod.POST) // Funciona
    public Project createProject(@PathVariable String idUser, @RequestBody Project project){
        return projectService.saveProject(project, idUser);
    }

    @RequestMapping(value = "/project/{idProject}", method = RequestMethod.GET)
    public Project getSingleProject(@PathVariable String idProject){ // Funciona
        return projectService.getProject(idProject);
    }

    @RequestMapping(value = "/project/all", method = RequestMethod.GET)
    public List<Project> getAllProject(@RequestBody User idUser){ // Funciona
        return projectService.getAllUserProject(idUser);
    }

    @RequestMapping(value = "/project/update/{idProject}", method = RequestMethod.POST) // Funciona
    public Project updateProject(@PathVariable String idProject, @RequestBody Project project){
        if(!Objects.isNull(project.getName())){
            projectService.updateName(idProject, project.getName());
        }
        if(!Objects.isNull(project.getDescription())){
            projectService.updateDescription(idProject, project.getDescription());
        }
        if(!Objects.isNull(project.getLinkGithub())){
            projectService.updateLinkGithub(idProject, project.getLinkGithub());
        }
        if(!Objects.isNull(project.getLinkProject())){
            projectService.updateLinkProject(idProject, project.getLinkProject());
        }
        return projectService.getProject(idProject);
    }

    @RequestMapping(value = "/project/delete/{idProject}", method = RequestMethod.DELETE)
    public String deleteProject(@PathVariable String idProject){ // Funciona
        return projectService.deleteProject(idProject);
    }

}

package com.leandro.backend.services;

import java.util.List;

import com.leandro.backend.models.Project;
import com.leandro.backend.models.User;

public interface ProjectService {
    
    Project saveProject(Project project, String idUser);
    Project getProject(String idProject);
    List<Project> getAllUserProject(User idUser);
    String deleteProject(String idProject);
    String deleteAllUserProject(User idUser);
    void updateIdUser(String id, String idUser);
    void updateName(String id, String name);
    void updateDescription(String id, String description);
    void updateLinkGithub(String id, String linkGithub);
    void updateLinkProject(String id, String linkProject);

}

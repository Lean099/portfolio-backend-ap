package com.leandro.backend.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.leandro.backend.models.Project;
import com.leandro.backend.models.User;
import com.leandro.backend.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
public class ProjectServiceImpl implements ProjectService{
    
    private final ProjectRepository projectRepo;
    private final EntityManager entityManager;

    @Override
    public Project saveProject(Project project, String idUser) {
        project.setIdUser(entityManager.getReference(User.class, idUser));
        return projectRepo.save(project);
    }

    @Override
    public Project getProject(String idProject) {
        return projectRepo.findById(idProject).get();
    }

    @Override
    public List<Project> getAllUserProject(String idUser) {
        User user = new User();
        user.setId(idUser);
        return projectRepo.findAllByIdUser(user);
    }

    @Override
    public String deleteProject(String idProject) {
        projectRepo.deleteById(idProject);
        boolean isPresent = projectRepo.existsById(idProject);
        if(isPresent){
            return "Could not be deleted";
        }
        return "Deleted successfully";
    }

    @Override
    public String deleteAllUserProject(String idUser) {
        projectRepo.deleteAll(getAllUserProject(idUser));
        return "All deleted";
    }

    @Override
    public void updateIdUser(String id, String idUser) {
        projectRepo.updateIdUser(id, idUser);
    }

    @Override
    public void updateName(String id, String name) {
        projectRepo.updateName(id, name);
    }

    @Override
    public void updateDescription(String id, String description) {
        projectRepo.updateDescription(id, description);
    }

    @Override
    public void updateEnddate(String id, Date enddate) {
        projectRepo.updateEnddate(id, enddate);
    }

    @Override
    public void updateLinkGithub(String id, String linkGithub) {
        projectRepo.updateLinkGithub(id, linkGithub);
    }

    @Override
    public void updateLinkProject(String id, String linkProject) {
        projectRepo.updateLinkProject(id, linkProject);
    }

}

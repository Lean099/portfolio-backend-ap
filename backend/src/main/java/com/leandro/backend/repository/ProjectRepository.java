package com.leandro.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Project;
import com.leandro.backend.models.User;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String>{
    
    @Modifying
    @Query("update Project p set p.idUser = :idUser where p.id = :id")
    void updateIdUser(@Param(value = "id") String id,
                      @Param(value = "idUser") String idUser);

    @Modifying
    @Query("update Project p set p.name = :name where p.id = :id")
    void updateName(@Param(value = "id") String id,
                    @Param(value = "name") String name);

    @Modifying
    @Query("update Project p set p.description = :description where p.id = :id")
    void updateDescription(@Param(value = "id") String id,
                           @Param(value = "description") String description);

    @Modifying
    @Query("update Project p set p.linkGithub = :linkGithub where p.id = :id")
    void updateLinkGithub(@Param(value = "id") String id,
                          @Param(value = "linkGithub") String linkGithub);

    @Modifying
    @Query("update Project p set p.linkProject = :linkProject where p.id = :id")
    void updateLinkProject(@Param(value = "id") String id,
                           @Param(value = "linkProject") String linkProject);

    List<Project> findAllByIdUser(User idUser);

}

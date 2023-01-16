package com.leandro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String>{
    
    @Modifying
    @Query("update Project p set p.id_user = :id_user where p.id = :id")
    String updateIdUser(@Param(value = "id") String id,
                        @Param(value = "id_user") String idUser);

    @Modifying
    @Query("update Project p set p.name = :name where p.id = :id")
    String updateName(@Param(value = "id") String id,
                      @Param(value = "name") String name);

    @Modifying
    @Query("update Project p set p.description = :description where p.id = :id")
    String updateDescription(@Param(value = "id") String id,
                             @Param(value = "description") String description);

    @Modifying
    @Query("update Project p set p.link_github = :link_github where p.id = :id")
    String updateLinkGithub(@Param(value = "id") String id,
                            @Param(value = "link_github") String link_github);

    @Modifying
    @Query("update Project p set p.link_project = :link_project where p.id = :id")
    String updateLinkProject(@Param(value = "id") String id,
                             @Param(value = "link_project") String link_project);

}

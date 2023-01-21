package com.leandro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, String>{
    
    @Modifying
    @Query("update Education e set e.idUser = :idUser where e.id = :id")
    void updateIdUser(@Param(value = "id") String id,
                      @Param(value = "idUser") String idUser);

    @Modifying
    @Query("update Education e set e.institution = :institution where e.id = :id")
    void updateInstitution(@Param(value = "id") String id,
                           @Param(value = "institution") String institution);

    @Modifying
    @Query("update Education e set e.degree = :degree where e.id = :id")
    void updateDegree(@Param(value = "id") String id,
                      @Param(value = "degree") String degree);

    @Modifying
    @Query("update Education e set e.enddate = :enddate where e.id = :id")
    void updateEnddate(@Param(value = "id") String id,
                       @Param(value = "enddate") String enddate);

    @Modifying
    @Query("update Education e set e.idPicture = :idPicture where e.id = :id")
    void updateIdPicture(@Param(value = "id") String id,
                         @Param(value = "idPicture") String idPicture);

}

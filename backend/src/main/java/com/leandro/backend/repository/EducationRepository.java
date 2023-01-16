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
    @Query("update Education e set e.id_user = :id_user where e.id = :id")
    String updateIdUser(@Param(value = "id") String id,
                        @Param(value = "id_user") String idUser);

    @Modifying
    @Query("update Education e set e.institution = :institution where e.id = :id")
    String updateInstitution(@Param(value = "id") String id,
                             @Param(value = "institution") String institution);

    @Modifying
    @Query("update Education e set e.degree = :degree where e.id = :id")
    String updateDegree(@Param(value = "id") String id,
                        @Param(value = "degree") String degree);

    @Modifying
    @Query("update Education e set e.enddate = :enddate where e.id = :id")
    String updateEnddate(@Param(value = "id") String id,
                         @Param(value = "enddate") String enddate);

    @Modifying
    @Query("update Education e set e.id_picture = :id_picture where e.id = :id")
    String updateIdPicture(@Param(value = "id") String id,
                           @Param(value = "id_picture") String idPicture);

}

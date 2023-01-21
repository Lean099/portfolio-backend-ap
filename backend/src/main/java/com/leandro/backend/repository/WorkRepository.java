package com.leandro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Work;

@Repository
public interface WorkRepository extends JpaRepository<Work, String> {
    
    @Modifying
    @Query("update Work w set w.idUser = :idUser where w.id = :id")
    void updateIdUser(@Param(value = "id") String id,
                      @Param(value = "idUser") String idUser);

    @Modifying
    @Query("update Work w set w.company = :company where w.id = :id")
    void updateCompany(@Param(value = "id") String id,
                       @Param(value = "company") String company);

    @Modifying
    @Query("update Work w set w.job = :job where w.id = :id")
    void updateJob(@Param(value = "id") String id,
                   @Param(value = "job") String job);

    @Modifying
    @Query("update Work w set w.startdate = :startdate where w.id = :id")
    void updateStartdate(@Param(value = "id") String id,
                         @Param(value = "startdate") String startdate);

    @Modifying
    @Query("update Work w set w.enddate = :enddate where w.id = :id")
    void updateEnddate(@Param(value = "id") String id,
                       @Param(value = "enddate") String enddate);

    @Modifying
    @Query("update Work w set w.idPicture = :idPicture where w.id = :id")
    void updateIdPicture(@Param(value = "id") String id,
                         @Param(value = "idPicture") String idPicture);

}

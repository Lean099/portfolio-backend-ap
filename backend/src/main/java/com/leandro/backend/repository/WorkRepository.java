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
    @Query("update Work w set w.id_user = :id_user where w.id = :id")
    String updateIdUser(@Param(value = "id") String id,
                        @Param(value = "id_user") String idUser);

    @Modifying
    @Query("update Work w set w.company = :company where w.id = :id")
    String updateCompany(@Param(value = "id") String id,
                         @Param(value = "company") String company);

    @Modifying
    @Query("update Work w set w.job = :job where w.id = :id")
    String updateJob(@Param(value = "id") String id,
                     @Param(value = "job") String job);

    @Modifying
    @Query("update Work w set w.startdate = :startdate where w.id = :id")
    String updateStartdate(@Param(value = "id") String id,
                           @Param(value = "startdate") String startdate);

    @Modifying
    @Query("update Work w set w.enddate = :enddate where w.id = :id")
    String updateEnddate(@Param(value = "id") String id,
                         @Param(value = "enddate") String enddate);

    @Modifying
    @Query("update Work w set w.id_picture = :id_picture where w.id = :id")
    String updateIdPicture(@Param(value = "id") String id,
                           @Param(value = "id_picture") String idPicture);

}

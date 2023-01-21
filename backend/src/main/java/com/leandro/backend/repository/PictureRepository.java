package com.leandro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, String>{
    
    @Modifying
    @Query("update Picture p set p.idUser = :idUser where p.id = :id")
    void updateIdUser(@Param(value = "id") String id,
                      @Param(value = "idUser") String idUser);

    @Modifying
    @Query("update Picture p set p.idEntity = :idEntity where p.id = :id")
    void updateIdEntity(@Param(value = "id") String id,
                        @Param(value = "idEntity") String idEntity);
                          
    @Modifying
    @Query("update Picture p set p.publicId = :publicId where p.id = :id")
    void updatePublicId(@Param(value = "id") String id,
                        @Param(value = "publicId") String publicId);

    @Modifying
    @Query("update Picture p set p.filename = :filename where p.id = :id")
    void updateFilename(@Param(value = "id") String id,
                        @Param(value = "filename") String filename);

    @Modifying
    @Query("update Picture p set p.url = :url where p.id = :id")
    void updateUrl(@Param(value = "id") String id,
                   @Param(value = "url") String url);

}

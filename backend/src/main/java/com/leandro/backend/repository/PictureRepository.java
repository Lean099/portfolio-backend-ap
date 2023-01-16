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
    @Query("update Picture p set p.id_user = :id_user where p.id = :id")
    String updateIdUser(@Param(value = "id") String id,
                        @Param(value = "id_user") String idUser);

    @Modifying
    @Query("update Picture p set p.id_entity = :id_entity where p.id = :id")
    String updateIdEntity(@Param(value = "id") String id,
                          @Param(value = "id_entity") String idEntity);
                          
    @Modifying
    @Query("update Picture p set p.public_id = :public_id where p.id = :id")
    String updatePublicId(@Param(value = "id") String id,
                          @Param(value = "public_id") String publicId);

    @Modifying
    @Query("update Picture p set p.filename = :filename where p.id = :id")
    String updateFilename(@Param(value = "id") String id,
                          @Param(value = "filename") String filename);

    @Modifying
    @Query("update Picture p set p.url = :url where p.id = :id")
    String updateUrl(@Param(value = "id") String id,
                     @Param(value = "url") String url);

}

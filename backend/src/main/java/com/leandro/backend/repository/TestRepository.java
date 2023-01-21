package com.leandro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, String>{
    
    @Modifying
    @Query("update Test t set t.name = :name where t.id = :id")
    void updateName(@Param(value = "id") String id,
                    @Param(value = "name") String name);

    @Modifying
    @Query("update Test t set t.password = :password where t.id = :id")
    void updatePassword(@Param(value = "id") String id,
                        @Param(value = "password") String password);

    @Modifying
    @Query("update Test t set t.dob = :dob  where t.id = :id")
    void updateDob(@Param(value = "id") String id,
                   @Param(value = "dob ") String dob );

    @Modifying
    @Query("update Test t set t.about  = :about where t.id = :id")
    void updateAbout(@Param(value = "id") String id,
                     @Param(value = "about") String about);               

}

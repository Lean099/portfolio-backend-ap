package com.leandro.backend.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    @Modifying
    @Query("update User u set u.firstname = :firstname where u.id = :id")
    String updateFirstname(@Param(value = "id") String id,
                           @Param(value = "firstname") String firstname);
    
    @Modifying
    @Query("update User u set u.lastname = :lastname where u.id = :id")
    String updateLastname(@Param(value = "id") String id,
                          @Param(value = "lastname") String lastname);

    @Modifying
    @Query("update User u set u.email = :email where u.id = :id")
    String updateEmail(@Param(value = "id") String id,
                       @Param(value = "email") String email);

    @Modifying
    @Query("update User u set u.password = :password where u.id = :id")
    void updatePassword(@Param(value = "id") String id,
                        @Param(value = "password") String password);

    @Modifying
    @Query("update User u set u.about = :about where u.id = :id")
    String updateAbout(@Param(value = "id") String id,
                       @Param(value = "about") String about);

    @Modifying
    @Query("update User u set u.dob = :dob where u.id = :id")
    Date updateDob(@Param(value = "id") String id,
                   @Param(value = "dob") String dob);

    @Modifying
    @Query("update User u set u.city = :city where u.id = :id")
    String updateCity(@Param(value = "id") String id,
                       @Param(value = "city") String city);

    @Modifying
    @Query("update User u set u.id_profile_picture = :id_profile_picture where u.id = :id")
    String updateIdProfilePicture(@Param(value = "id") String id,
                       @Param(value = "id_profile_picture") String idProfilePicture);

                       @Modifying
    @Query("update User u set u.id_banner_picture = :id_banner_picture where u.id = :id")
    String updateIdBannerPicture(@Param(value = "id") String id,
                       @Param(value = "id_banner_picture") String idBannerPicture);
}

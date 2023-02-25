package com.leandro.backend.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Address;
import com.leandro.backend.models.Picture;
import com.leandro.backend.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    @Modifying
    @Query("update User u set u.firstname = :firstname where u.id = :id")
    void updateFirstname(@Param(value = "id") String id,
                         @Param(value = "firstname") String firstname);
    
    @Modifying
    @Query("update User u set u.lastname = :lastname where u.id = :id")
    void updateLastname(@Param(value = "id") String id,
                        @Param(value = "lastname") String lastname);

    @Modifying
    @Query("update User u set u.email = :email where u.id = :id")
    void updateEmail(@Param(value = "id") String id,
                     @Param(value = "email") String email);

    @Modifying
    @Query("update User u set u.password = :password where u.id = :id")
    void updatePassword(@Param(value = "id") String id,
                        @Param(value = "password") String password);

    @Modifying
    @Query("update User u set u.about = :about where u.id = :id")
    void updateAbout(@Param(value = "id") String id,
                     @Param(value = "about") String about);

    @Modifying
    @Query("update User u set u.dob = :dob where u.id = :id")
    void updateDob(@Param(value = "id") String id,
                   @Param(value = "dob") Date dob);

    @Modifying
    @Query("update User u set u.address = :address where u.id = :id")
    void updateAddress(@Param(value = "id") String id,
                       @Param(value = "address") Address address);

    @Modifying
    @Query("update User u set u.idProfilePicture = :idProfilePicture where u.id = :id")
    void updateIdProfilePicture(@Param(value = "id") String id,
                                @Param(value = "idProfilePicture") Picture idProfilePicture);

    @Modifying
    @Query("update User u set u.idBannerPicture = :idBannerPicture where u.id = :id")
    void updateIdBannerPicture(@Param(value = "id") String id,
                               @Param(value = "idBannerPicture") Picture idBannerPicture);

    Optional<User> findByEmail(String email);  // Funciona tambien sin el optional y solo User
                               
}

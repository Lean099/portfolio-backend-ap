package com.leandro.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, String>{
    
    @Modifying
    @Query("update Location l set l.id_user = :id_user where l.id = :id")
    String updateIdUser(@Param(value = "id") String id,
                        @Param(value = "id_user") String idUser);

    @Modifying
    @Query("update Location l set l.country = :country where l.id = :id")
    String updateCountry(@Param(value = "id") String id,
                         @Param(value = "country") String country);

    @Modifying
    @Query("update Location l set l.city = :city where l.id = :id")
    String updateCity(@Param(value = "id") String id,
                      @Param(value = "city") String city);

    @Modifying
    @Query("update Location l set l.location = :location where l.id = :id")
    String updateLocation(@Param(value = "id") String id,
                          @Param(value = "location") String location);

}

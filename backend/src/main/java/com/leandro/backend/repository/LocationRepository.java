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
    @Query("update Location l set l.idUser = :idUser where l.id = :id")
    void updateIdUser(@Param(value = "id") String id,
                      @Param(value = "idUser") String idUser);

    @Modifying
    @Query("update Location l set l.country = :country where l.id = :id")
    void updateCountry(@Param(value = "id") String id,
                       @Param(value = "country") String country);

    @Modifying
    @Query("update Location l set l.city = :city where l.id = :id")
    void updateCity(@Param(value = "id") String id,
                    @Param(value = "city") String city);

    @Modifying
    @Query("update Location l set l.location = :location where l.id = :id")
    void updateLocation(@Param(value = "id") String id,
                        @Param(value = "location") String location);

}

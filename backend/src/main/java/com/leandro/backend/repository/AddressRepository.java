package com.leandro.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Address;
import com.leandro.backend.models.Country;
import com.leandro.backend.models.City;
import com.leandro.backend.models.Province;
import com.leandro.backend.models.User;

@Repository
public interface AddressRepository extends JpaRepository<Address, String>{
    
    @Modifying
    @Query("update Address a set a.idUser = :idUser where a.id = :id")
    void updateIdUser(@Param(value = "id") String id,
                      @Param(value = "idUser") User idUser);

    @Modifying
    @Query("update Address a set a.country = :country where a.id = :id")
    void updateCountry(@Param(value = "id") String id,
                       @Param(value = "country") Country country);

    @Modifying
    @Query("update Address a set a.city = :city where a.id = :id")
    void updateCity(@Param(value = "id") String id,
                    @Param(value = "city") City city);

    @Modifying
    @Query("update Address a set a.province = :province where a.id = :id")
    void updateProvince(@Param(value = "id") String id,
                        @Param(value = "province") Province province);

    Optional<Address> findByIdUser(User idUser);

}

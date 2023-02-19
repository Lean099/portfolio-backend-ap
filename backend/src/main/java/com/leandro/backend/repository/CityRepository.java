package com.leandro.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, String> {

    boolean existsByName(String name);

    Optional<City> findByName(String name);

}

package com.leandro.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String>{
    
    boolean existsByName(String name);

    Optional<Country> findByName(String name);

}

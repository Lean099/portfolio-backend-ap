package com.leandro.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.backend.models.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String>{
    
    boolean existsByName(String name);

    Optional<Province> findByName(String name);

}

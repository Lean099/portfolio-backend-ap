package com.leandro.backend.services;

import org.springframework.stereotype.Service;

import com.leandro.backend.models.City;
import com.leandro.backend.repository.CityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@org.springframework.transaction.annotation.Transactional
public class CityServiceImpl implements CityService {
    
    private final CityRepository cityRepo;

    @Override
    public City saveCity(City city) {  // Funciona
        if(cityRepo.existsByName(city.getName().toUpperCase())){
            return cityRepo.findByName(city.getName().toUpperCase()).get();
        }else{
            city.setName(city.getName().toUpperCase());
            return cityRepo.saveAndFlush(city);
        }
    }

    @Override
    public City getCity(String nameCity) {  // Funciona
        return cityRepo.findByName(nameCity.toUpperCase()).get();
    }

    @Override
    public void deleteCity(String idCity) {  // Funciona
        cityRepo.deleteById(idCity);
    }

    @Override
    public boolean existsByName(String nameCity) {  // Funciona
        return cityRepo.existsByName(nameCity.toUpperCase());
    }

}

package com.leandro.backend.services;

import com.leandro.backend.models.City;

public interface CityService {
    
    City saveCity(City city);
    City getCity(String nameCity);
    void deleteCity(String idCity);
    boolean existsByName(String nameCity);

}

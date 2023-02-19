package com.leandro.backend.services;

import com.leandro.backend.models.Country;

public interface CountryService {
    
    Country saveCountry(Country country);
    Country getCountry(String nameCountry);
    void deleteCountry(String idCountry);
    boolean existsByName(String nameCountry);
    
}

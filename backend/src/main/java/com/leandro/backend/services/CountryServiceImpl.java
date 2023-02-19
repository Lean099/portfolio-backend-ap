package com.leandro.backend.services;

import org.springframework.stereotype.Service;

import com.leandro.backend.models.Country;
import com.leandro.backend.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
public class CountryServiceImpl implements CountryService {
    
    private final CountryRepository countryRepo;

    @Override
    public Country saveCountry(Country country) {   // Funciona
        if(countryRepo.existsByName(country.getName().toUpperCase())){
            return countryRepo.findByName(country.getName().toUpperCase()).get();
        }else{
            country.setName(country.getName().toUpperCase());
            return countryRepo.saveAndFlush(country);
        }
    }

    @Override
    public Country getCountry(String nameCountry) {  // Funciona
        return countryRepo.findByName(nameCountry.toUpperCase()).get();
    }

    @Override
    public void deleteCountry(String idCountry) {  // Funciona
        countryRepo.deleteById(idCountry);  
    }

    @Override
    public boolean existsByName(String nameCountry) {  // Funciona
        return countryRepo.existsByName(nameCountry.toUpperCase());
    }

}

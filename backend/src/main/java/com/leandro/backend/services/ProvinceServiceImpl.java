package com.leandro.backend.services;

import org.springframework.stereotype.Service;

import com.leandro.backend.models.Province;
import com.leandro.backend.repository.ProvinceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@org.springframework.transaction.annotation.Transactional
public class ProvinceServiceImpl implements ProvinceService{
    
    private final ProvinceRepository provinceRepo;

    @Override
    public Province saveProvince(Province province) {   // Funciona
        if(provinceRepo.existsByName(province.getName().toUpperCase())){
            return provinceRepo.findByName(province.getName().toUpperCase()).get();
        }else{
            province.setName(province.getName().toUpperCase());
            return provinceRepo.saveAndFlush(province);
        }
    }

    @Override
    public Province getProvince(String nameProvince) {  // Funciona
        return provinceRepo.findByName(nameProvince.toUpperCase()).get();
    }

    @Override
    public void deleteProvince(String idProvince) {     // Funciona
        provinceRepo.deleteById(idProvince);
    }

    @Override
    public boolean existsByName(String nameProvince) {    // Funciona  
        return provinceRepo.existsByName(nameProvince.toUpperCase());
    }

}

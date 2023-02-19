package com.leandro.backend.services;

import com.leandro.backend.models.Province;

public interface ProvinceService {
    
    Province saveProvince(Province province);
    Province getProvince(String nameProvince);
    void deleteProvince(String idProvince);
    boolean existsByName(String nameProvince);

}

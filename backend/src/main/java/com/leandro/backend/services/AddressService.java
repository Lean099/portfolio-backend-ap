package com.leandro.backend.services;

import com.leandro.backend.models.Address;
import com.leandro.backend.models.City;
import com.leandro.backend.models.Country;
import com.leandro.backend.models.Province;

public interface AddressService {
    
    Address saveAddress(String idUser, Address address);
    Address getAddress(String idAddress);
    Address getAddressByIdUser(String idUser);
    void deleteAddress(String idAddress);
    void updateCountry(String id, Country country);
    void updateCity(String id, City city);
    void updateProvince(String id, Province province);

}

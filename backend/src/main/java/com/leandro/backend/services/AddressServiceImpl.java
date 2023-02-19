package com.leandro.backend.services;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.leandro.backend.models.Address;
import com.leandro.backend.models.City;
import com.leandro.backend.models.Country;
import com.leandro.backend.models.Province;
import com.leandro.backend.models.User;
import com.leandro.backend.repository.AddressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
public class AddressServiceImpl implements AddressService {
    
    private final AddressRepository addressRepo;
    private final EntityManager entityManager;
    @Lazy
    @Autowired
    private UserService userService;
    @Lazy
    @Autowired
    private CountryService countryService;
    @Lazy
    @Autowired
    private CityService cityService;
    @Lazy
    @Autowired
    private ProvinceService provinceService;
    

    @Override
    public Address saveAddress(String idUser, Address address) {  // Funciona
        address.setIdUser(entityManager.getReference(User.class, idUser));
        if(Objects.nonNull(address.getCountry())){
            address.setCountry(countryService.saveCountry(address.getCountry()));
        }
        if(Objects.nonNull(address.getCity())){
            address.setCity(cityService.saveCity(address.getCity()));
        }
        if(Objects.nonNull(address.getProvince())){
            address.setProvince(provinceService.saveProvince(address.getProvince()));
        }
        Address savedAddress = addressRepo.saveAndFlush(address);
        userService.updateAddress(address.getIdUser(), savedAddress);
        return savedAddress;
    }

    @Override
    public Address getAddress(String idAddress) {   // Funciona
        return addressRepo.findById(idAddress).get();
    }

    @Override
    public void deleteAddress(String idAddress) {  // Funciona
        Address a = getAddress(idAddress);
        addressRepo.deleteById(a.getId());
        userService.updateAddress(a.getIdUser(), null);
    }

    @Override
    public void updateCountry(String id, Country country) {     // Funciona
        if(countryService.existsByName(country.getName())){
            addressRepo.updateCountry(id, countryService.getCountry(country.getName()));
        }else{
            addressRepo.updateCountry(id, countryService.saveCountry(country));
        }
    }

    @Override
    public void updateCity(String id, City city) {      // Funciona
        if(cityService.existsByName(city.getName())){
            addressRepo.updateCity(id, cityService.getCity(city.getName()));
        }else{
            addressRepo.updateCity(id, cityService.saveCity(city));
        }
    }

    @Override
    public void updateProvince(String id, Province province) {      // Funciona
        if(provinceService.existsByName(province.getName())){
            addressRepo.updateProvince(id, provinceService.getProvince(province.getName()));
        }else{
            addressRepo.updateProvince(id, provinceService.saveProvince(province));
        }
    }

    // Solo para testear
    @Override
    public List<Address> getAll() {
        return addressRepo.findAll();
    }

        

}

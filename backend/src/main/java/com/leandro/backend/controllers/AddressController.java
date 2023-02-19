package com.leandro.backend.controllers;

import java.util.Objects;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.models.Address;
import com.leandro.backend.services.AddressService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AddressController {
    
    private final AddressService addressService;

    @RequestMapping(value = "/address/create/{idUser}", method = RequestMethod.POST)
    public Address createAddress(@PathVariable String idUser, @RequestBody Address address){
        return addressService.saveAddress(idUser, address);     // Funciona
    }

    @RequestMapping(value = "/address/{idAddress}", method = RequestMethod.GET)
    public Address getAddress(@PathVariable String idAddress){      // Funciona
        return addressService.getAddress(idAddress);
    }

    @RequestMapping(value = "/address/update", method = RequestMethod.POST)
    public Address updateAddress(@RequestBody Address address){     // Funciona
        String id = address.getId();
        if(Objects.nonNull(address.getCountry())){
            addressService.updateCountry(id, address.getCountry());
        }
        if(Objects.nonNull(address.getCity())){
            addressService.updateCity(id, address.getCity());
        }
        if(Objects.nonNull(address.getProvince())){
            addressService.updateProvince(id, address.getProvince());
        }
        return addressService.getAddress(id);
    }

    @RequestMapping(value = "/address/delete/{idAddress}", method = RequestMethod.DELETE)
    public void deleteAddress(@PathVariable String idAddress){  // Funciona
        addressService.deleteAddress(idAddress);
    }

}

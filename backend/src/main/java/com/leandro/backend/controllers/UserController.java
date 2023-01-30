package com.leandro.backend.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.models.User;
import com.leandro.backend.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(String id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public List<User> getAllUser(String id){
        return userService.getAll();
    }

    @RequestMapping(value = "/user/updatePI", method = RequestMethod.POST)
    public String updatePersonalInformation(@RequestBody PersonalInformation pi){
        // Firstname, lastname, dob, city
        return null;
    }

    @RequestMapping(value = "/user/updateEP", method = RequestMethod.POST)
    public String updateEmailAndPassword(@RequestBody Credentials credentials){
        return null;
    }

    @RequestMapping(value = "/user/updateAbout", method = RequestMethod.POST)
    public String updateAbout(String id, String about){
        return null;
    }

}

class PersonalInformation{
    String id;
    String firstname;
    String lastname;
    Date dob;
    String city;
}

class Credentials{
    String id;
    String email;
    String password;
}

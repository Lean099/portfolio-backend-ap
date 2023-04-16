package com.leandro.backend.controllers;

import java.util.Objects;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.models.User;
import com.leandro.backend.services.UserService;
import com.leandro.backend.utils.DefaultUser;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "/user/create", method = RequestMethod.POST) // Funciona
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET) // Funciona
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user/defaultUser/{idUser}", method = RequestMethod.GET) // Funciona
    public DefaultUser getDefaultUser(@PathVariable String idUser){
        return userService.getDefaultDataUser(idUser);
    }

    @RequestMapping(value = "/user/updatePI", method = RequestMethod.POST)
    public User updatePersonalInformation(@RequestBody User pi){ // Funciona
        // Firstname, lastname, dob, about, phone, github, linkedin
        String id = pi.getId();
        if(!Objects.isNull(pi.getFirstname())){
            userService.updateFirstName(id, pi.getFirstname());
        }
        if(!Objects.isNull(pi.getLastname())){
            userService.updateLastName(id, pi.getLastname());
        }
        if(!Objects.isNull(pi.getDob())){
            userService.updateDob(id, pi.getDob());
        }
        if(!Objects.isNull(pi.getAbout())){
            userService.updateAbout(id, pi.getAbout());
        }
        if(!Objects.isNull(pi.getPhone())){
            userService.updatePhone(id, pi.getPhone());
        }
        if(!Objects.isNull(pi.getGithubUrl())){
            userService.updateGithubUrl(id, pi.getGithubUrl());
        }
        if(!Objects.isNull(pi.getLinkedinUrl())){
            userService.updateLinkedinUrl(id, pi.getLinkedinUrl());
        }
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user/updateEP", method = RequestMethod.POST)
    public User updateEmailAndPassword(@RequestBody User credentials){ // Funciona
        String id = credentials.getId();
        if(!Objects.isNull(credentials.getEmail())){
            userService.updateEmail(id, credentials.getEmail());
        }
        if(!Objects.isNull(credentials.getPassword())){
            userService.updatePassword(id, credentials.getPassword());
        }
        return userService.getUser(credentials.getId());
    }

}

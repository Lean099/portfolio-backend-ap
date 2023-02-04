package com.leandro.backend.controllers;

import java.util.List;
import java.util.Objects;

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

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable String id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @RequestMapping(value = "/user/updatePI", method = RequestMethod.POST)
    public User updatePersonalInformation(@RequestBody User pi){ // Funciona
        // Firstname, lastname, dob, about
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
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user/updateEP", method = RequestMethod.POST)
    public User updateEmailAndPassword(@RequestBody User credentials){ // Funciona
        log.info(credentials.getId());
        String id = credentials.getId();
        if(!Objects.isNull(credentials.getEmail())){
            userService.updateEmail(id, credentials.getEmail());
        }
        if(!Objects.isNull(credentials.getPassword())){
            userService.updatePassword(id, credentials.getPassword());
        }
        return userService.getUser(credentials.getId());
    }

    @RequestMapping(value = "/user/updateCity", method = RequestMethod.POST)
    public String updateCity(String id, String city){
        return null;
    }

    @RequestMapping(value = "/user/uploadPicture", method = RequestMethod.POST)
    public String uploadPicture(){
        return null;
    }

}

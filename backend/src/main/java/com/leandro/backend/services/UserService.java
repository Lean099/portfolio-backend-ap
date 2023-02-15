package com.leandro.backend.services;

import java.util.Date;
import java.util.List;

import com.leandro.backend.models.Picture;
import com.leandro.backend.models.User;

public interface UserService {
    
    User saveUser(User user);
    User getUser(String id);
    List<User> getAll();
    void hasAProfilePicture(String idUser);
    void hasABannerPicture(String idUser);
    void updateFirstName(String id, String firstname);
    void updateLastName(String id, String lastname);
    void updateEmail(String id, String email);
    void updatePassword(String id, String password);
    void updateAbout(String id, String about);
    void updateDob(String id, Date dob);  // Haremos una logica para que la edad sea valida si es mayor a 18
    void updateCity(String idUser, String idCity);
    void updateIdProfilePicture(String idUser, Picture idPicture);
    void updateIdBannerPicture(String idUser, Picture idPicture);
    
}

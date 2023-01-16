package com.leandro.backend.services;

import java.util.Date;
import java.util.List;

import com.leandro.backend.models.User;

public interface UserService {
    
    User saveUser(User user);
    User getUser(String id);
    List<User> getAll();
    String updateFirstName(String id, String firstname);
    String updateLastName(String id, String lastname);
    String updateEmail(String id, String email);
    void updatePassword(String id, String password);
    String updateAbout(String id, String about);
    Date updateDob(String id, Date dob);  // Haremos una logica para que la edad sea valida si es mayor a 18
    String updateCity(String idUser, String idCity);
    void updateIdProfilePicture(String idUser, String idPicture);
    void updateIdBannerPicture(String idUser, String idPicture);
    
}

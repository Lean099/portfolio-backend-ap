package com.leandro.backend.services;

import java.util.Date;
import java.util.List;

import com.leandro.backend.models.Address;
import com.leandro.backend.models.Picture;
import com.leandro.backend.models.User;
import com.leandro.backend.utils.DefaultUser;

public interface UserService {
    
    User saveUser(User user);
    User getUser(String id);
    List<User> getAll();
    DefaultUser getDefaultDataUser(String idUser);
    void hasAProfilePicture(String idUser);
    void hasABannerPicture(String idUser);
    void updateFirstName(String id, String firstname);
    void updateLastName(String id, String lastname);
    void updateEmail(String id, String email);
    void updatePassword(String id, String password);
    void updateAbout(String id, String about);
    void updatePhone(String id, String phone);
    void updateGithubUrl(String id, String githubUrl);
    void updateLinkedinUrl(String id, String linkedinUrl);
    void updateDob(String id, Date dob);
    void updateAddress(String idUser, Address idAddress);
    void updateIdProfilePicture(String idUser, Picture idPicture);
    void updateIdBannerPicture(String idUser, Picture idPicture);
    
}

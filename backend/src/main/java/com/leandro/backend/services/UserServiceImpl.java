package com.leandro.backend.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.leandro.backend.models.User;
import com.leandro.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepo;

    @Override
    public User saveUser(User user) {
        // Faltaria que antes de guardar el user en la db encripte el password, cuando lleguemos a spring security
        return userRepo.save(user);
    }

    @Override
    public User getUser(String id) {
        return userRepo.getReferenceById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public String updateFirstName(String id, String firstname) {
        return userRepo.updateFirstname(id, firstname);
    }

    @Override
    public String updateLastName(String id, String lastname) {
        return userRepo.updateLastname(id, lastname);
    }

    @Override
    public String updateEmail(String id, String email) {
        return userRepo.updateEmail(id, email);
    }

    @Override
    public void updatePassword(String id, String password) {
        userRepo.updatePassword(id, password); // Antes tiene que ir la encriptacion y luego lo pasamos
    }

    @Override
    public String updateAbout(String id, String about) {
        return userRepo.updateAbout(id, about);
    }

    @Override
    public Date updateDob(String id, Date dob) {
        return userRepo.updateDob(id, id);
    }

    @Override
    public String updateCity(String idUser, String idCity) {
        return userRepo.updateCity(idUser, idCity);
    }

    @Override
    public void updateIdProfilePicture(String idUser, String idPicture) {
        userRepo.updateIdProfilePicture(idUser, idPicture);
    }

    @Override
    public void updateIdBannerPicture(String idUser, String idPicture) {
        userRepo.updateIdBannerPicture(idUser, idPicture);
    }

}

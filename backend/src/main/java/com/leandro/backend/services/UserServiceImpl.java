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
        return null;
    }

    @Override
    public String updateLastName(String id, String lastname) {
        return null;
    }

    @Override
    public String updateEmail(String id, String email) {
        return null;
    }

    @Override
    public void updatePassword(String id, String password) {
         // Antes tiene que ir la encriptacion y luego lo pasamos
    }

    @Override
    public String updateAbout(String id, String about) {
        return null;
    }

    @Override
    public Date updateDob(String id, Date dob) {
        return null;
    }

    @Override
    public String updateCity(String idUser, String idCity) {
        return null;
    }

    @Override
    public void updateIdProfilePicture(String idUser, String idPicture) {
        
    }

    @Override
    public void updateIdBannerPicture(String idUser, String idPicture) {
        
    }

}

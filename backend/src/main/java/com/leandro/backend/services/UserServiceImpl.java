package com.leandro.backend.services;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.leandro.backend.models.Picture;
import com.leandro.backend.models.User;
import com.leandro.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepo;
    @Lazy
    @Autowired
    private PictureService pictureService;

    @Override
    public User saveUser(User user) {
        // Faltaria que antes de guardar el user en la db encripte el password, cuando lleguemos a spring security
        return userRepo.save(user);
    }

    @Override
    public User getUser(String id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public void hasAProfilePicture(String idUser) {
        User user = getUser(idUser);
        if(Objects.nonNull(user.getIdProfilePicture())){
            String idPicture = user.getIdProfilePicture().getId();
            String idPic = pictureService.findPicture(idPicture).getId();
            pictureService.destroyFile(idPic);
            updateIdProfilePicture(idUser, null);
        }else{
            return;
        }
    }

    @Override
    public void hasABannerPicture(String idUser) {
        User user = getUser(idUser);
        if(Objects.nonNull(user.getIdBannerPicture())){
            String idPicture = user.getIdBannerPicture().getId();
            String idPic = pictureService.findPicture(idPicture).getId();
            pictureService.destroyFile(idPic);
            updateIdBannerPicture(idUser, null);
        }
    }

    @Override
    public void updateFirstName(String id, String firstname) {
        userRepo.updateFirstname(id, firstname);
    }

    @Override
    public void updateLastName(String id, String lastname) {
        userRepo.updateLastname(id, lastname);;
    }

    @Override
    public void updateEmail(String id, String email) {
        userRepo.updateEmail(id, email);;
    }

    @Override
    public void updatePassword(String id, String password) {
         // Antes tiene que ir la encriptacion y luego lo pasamos
         userRepo.updatePassword(id, password);
    }

    @Override
    public void updateAbout(String id, String about) {
        userRepo.updateAbout(id, about);;
    }

    @Override
    public void updateDob(String id, Date dob) {
        userRepo.updateDob(id, dob);;
    }

    @Override
    public void updateCity(String idUser, String idCity) {
        userRepo.updateCity(idUser, idCity);;
    }

    @Override
    public void updateIdProfilePicture(String idUser, Picture idPicture) {
        userRepo.updateIdProfilePicture(idUser, idPicture);
    }

    @Override
    public void updateIdBannerPicture(String idUser, Picture idPicture) {
        userRepo.updateIdBannerPicture(idUser, idPicture);
    }

}

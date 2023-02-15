package com.leandro.backend.services;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.cloudinary.utils.ObjectUtils;
import com.leandro.backend.cloudinary.CloudinaryConfig;
import com.leandro.backend.models.Picture;
import com.leandro.backend.models.User;
import com.leandro.backend.repository.PictureRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
public class PictureServiceImpl implements PictureService {
    
    @Autowired
    private CloudinaryConfig cloudinaryConfig;
    private final PictureRepository pictureRepo;
    private final EntityManager entityManager;
    @Lazy
    @Autowired
    private UserService userService;
    @Lazy
    @Autowired
    private WorkService workService;
    @Lazy
    @Autowired
    private EducationService educationService;
    

    @Override
    public Picture uploadPicture(byte[] fileBytes, String originalFilename, String idUser, String type, String idEntity) {
        cloudinaryConfig.writeFileToUploadFolder(fileBytes, originalFilename);
        hasAPicture(idUser, idEntity, type);
        Map infoFile = cloudinaryConfig.uploadFile(originalFilename);
        cloudinaryConfig.deleteFileInUploadFolder();
        Picture newPicture = new Picture();
        newPicture.setIdEntity(idEntity);
        newPicture.setIdUser(entityManager.getReference(User.class, idUser));
        newPicture.setPublicId((String) infoFile.get("public_id"));
        newPicture.setFilename((String) infoFile.get("original_filename"));
        newPicture.setUrl((String) infoFile.get("url"));
        //Picture savedPic = pictureRepo.save(newPicture);
        Picture savedPic = pictureRepo.saveAndFlush(newPicture);
        updateIdPictureUserOrEntity(idUser, idEntity, savedPic, type);
        return savedPic;
    }

    @Override
    public Picture findPicture(String idPicture) {
        return pictureRepo.findById(idPicture).get();
    }

    @Override
    public List<Picture> getUserProfileAndBanner(String idUser) {
        return pictureRepo.findAllByIdUserAndIdEntity(idUser);
    }

    @Override
    public void destroyFile(String idPicture) {
        Picture pic = pictureRepo.findById(idPicture).get();
        try{
            cloudinaryConfig.cloudinaryConfig().uploader().destroy(pic.getPublicId(), ObjectUtils.emptyMap());
            pictureRepo.deleteById(idPicture);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void hasAPicture(String idUser, String idEntity, String type) {
        if(type.equals("profile")){
            userService.hasAProfilePicture(idUser);
        }
        if(type.equals("banner")){
            userService.hasABannerPicture(idUser);
        }
        if(type.equals("work")){
            workService.hasAPicture(idEntity);
        }
        if(type.equals("education")){
            educationService.hasAPicture(idEntity);
        }
    }

    @Override
    public void updateIdPictureUserOrEntity(String idUser, String idEntity, Picture data, String type) {
        if(type.equals("profile")){
            userService.updateIdProfilePicture(idUser, data);
        }
        if(type.equals("banner")){
            userService.updateIdBannerPicture(idUser, data);
        }
        if(type.equals("work")){
            workService.updateIdPicture(idEntity, data);
        }
        if(type.equals("education")){
            educationService.updateIdPicture(idEntity, data);
        }
    }

}

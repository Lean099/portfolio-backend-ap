package com.leandro.backend.services;

import java.util.List;

import com.leandro.backend.models.Picture;

public interface PictureService {
    
    Picture uploadPicture(byte[] fileBytes, String originalFilename, String idUser, String type, String idEntity);
    Picture findPicture(String idPicture);
    List<Picture> getUserProfileAndBanner(String idUser);
    void destroyFile(String idPicture);
    void hasAPicture(String idUser, String idEntity, String type);
    void updateIdPictureUserOrEntity(String idUser, String idEntity, Picture data, String type);

}

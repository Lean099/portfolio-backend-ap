package com.leandro.backend.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.ValidationException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.leandro.backend.models.Picture;
import com.leandro.backend.services.PictureService;
import com.leandro.backend.utils.RequestDeletePicture;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PictureController {
    
    private final PictureService pictureService;

    // Funciona
    @RequestMapping(value = "/picture/upload/{idUser}/{type}", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadPicture(@PathVariable String idUser,
                                 @PathVariable String type,
                                 @RequestParam("file") MultipartFile file,
                                 @RequestParam(required = false, value = "idEntity") String idEntity) throws ValidationException{
        //if(file.isEmpty()){
            String pictureUrl = "";
            try {
                byte[] fileBytes = file.getBytes();
                Picture pic = pictureService.uploadPicture(fileBytes, file.getOriginalFilename(), idUser, type, idEntity);
                pictureUrl = pic.getUrl();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("message", "Image uploaded successfully");
            responseMap.put("url", pictureUrl);
            return ResponseEntity.ok().body(responseMap);
        //}else{
            //throw new ValidationException("The file was not chosen in the form-data, the file has no content, or another problem occurred.");
        //}
        
    }

    @RequestMapping(value = "/picture/findOne/{idPicture}", method = RequestMethod.GET)
    public Picture getPicture(@PathVariable String idPicture){ // Funciona
        return pictureService.findPicture(idPicture);
    }

    @RequestMapping(value = "/picture/profileAndBanner/{idUser}", method = RequestMethod.GET)
    public List<Picture> getBannerAndProfilePicture(@PathVariable String idUser){ // Funciona
        return pictureService.getUserProfileAndBanner(idUser);
    }

    @RequestMapping(value = "/picture/delete", method = RequestMethod.DELETE) // Funciona
    public void deletePicture(@RequestBody RequestDeletePicture data){ 
        pictureService.hasAPicture(data.getIdUser(), data.getIdEntity(), data.getType());
    }

}

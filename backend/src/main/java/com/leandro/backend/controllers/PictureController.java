package com.leandro.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.models.Picture;
import com.leandro.backend.services.PictureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PictureController {
    
    private final PictureService pictureService;

    @RequestMapping(value = "/picture/upload", method = RequestMethod.POST)
    public Picture uploadPicture(@RequestBody Picture picture){
        return null;
    }

    @RequestMapping(value = "/picture/{idUser}", method = RequestMethod.GET)
    public List<Picture> getBannerAndProfilePicture(@PathVariable String idUser){
        return null;
    }

}

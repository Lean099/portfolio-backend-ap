package com.leandro.backend.services;

import java.util.Date;
import java.util.List;

import com.leandro.backend.models.Education;
import com.leandro.backend.models.Picture;
import com.leandro.backend.models.User;

public interface EducationService {
    
    Education saveEducation(Education education, String idUser);
    Education getSingleEducation(String idEducation);
    List<Education> getAllUserEducation(String idUser);
    String deleteEducation(String idEducation);
    String deleteAllUserEducation(String idUser);
    void hasAPicture(String idEducation);
    void updateIdUser(String id, User idUser);
    void updateInstitution(String id, String institution);
    void updateDegree(String id, String degree);
    void updateEnddate(String id, Date enddate);
    void updateIdPicture(String id, Picture idPicture);
    
}

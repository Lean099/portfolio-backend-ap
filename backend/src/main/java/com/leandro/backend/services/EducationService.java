package com.leandro.backend.services;

import java.util.Date;
import java.util.List;

import com.leandro.backend.models.Education;
import com.leandro.backend.models.User;

public interface EducationService {
    
    Education savEducation(Education education, String idEducation);
    Education getSingleEducation(String idEducation);
    List<Education> getAllUserEducation(User idUser);
    String deleteEducation(String idEducation);
    String deleteAllUserEducation(User idUser);
    void updateIdUser(String id, String idUser);
    void updateInstitution(String id, String institution);
    void updateDegree(String id, String degree);
    void updateEnddate(String id, Date enddate);
    void updateIdPicture(String id, String idPicture);
    
}

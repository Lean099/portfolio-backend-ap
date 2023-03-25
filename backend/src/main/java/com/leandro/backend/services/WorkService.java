package com.leandro.backend.services;

import java.util.Date;
import java.util.List;

import com.leandro.backend.models.Picture;
import com.leandro.backend.models.User;
import com.leandro.backend.models.Work;

public interface WorkService {
    
    Work saveWork(Work work, String idUser);
    Work getWork(String idWork);
    List<Work> getAllUserWork(String idUser);
    String deleteWork(String idWork);
    String deleteAllUserWork(String idUser);
    void hasAPicture(String idWork);
    void updateIdUser(String idWork, User idUser);
    void updateCompany(String idWork, String company);
    void updateJob(String idWork, String job);
    void updateStartDate(String idWork, Date sDate);
    void updateEnddate(String idWork, Date eDate);
    void updateIdPicture(String idWork, Picture idPicture);

}

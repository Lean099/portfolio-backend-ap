package com.leandro.backend.services;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.leandro.backend.models.Picture;
import com.leandro.backend.models.User;
import com.leandro.backend.models.Work;
import com.leandro.backend.repository.WorkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
public class WorkServiceImpl implements WorkService{
    
    private final WorkRepository workRepo;
    private final EntityManager entityManager;
    @Lazy
    @Autowired
    private PictureService pictureService;

    @Override
    public Work saveWork(Work work, String idUser) {
        work.setIdUser(entityManager.getReference(User.class, idUser));
        return workRepo.save(work);
    }

    @Override
    public Work getWork(String idWork) {
        return workRepo.findById(idWork).get();
    }

    @Override
    public List<Work> getAllUserWork(String idUser) {
        User user = new User();
        user.setId(idUser);
        return workRepo.findAllByIdUser(user);
    }

    @Override
    public String deleteWork(String idWork) {
        workRepo.deleteById(idWork);
        boolean isPresent = workRepo.findById(idWork).isPresent();
        if(isPresent){
            return "Could not be deleted";
        }
        return "Deleted successfully";
    }

    @Override
    public String deleteAllUserWork(String idUser) {
        workRepo.deleteAll(getAllUserWork(idUser));
        return "All deleted";
    }

    @Override
    public void hasAPicture(String idWork) {
        Work work = getWork(idWork);
        if(Objects.nonNull(work.getIdPicture())){
            String idPicture = work.getIdPicture().getId();
            String idPic = pictureService.findPicture(idPicture).getId();
            pictureService.destroyFile(idPic);
            updateIdPicture(idWork, null);
        }else{
            return;
        }
    }

    @Override
    public void updateIdUser(String idWork, User idUser) {
        workRepo.updateIdUser(idWork, idUser);
    }

    @Override
    public void updateCompany(String idWork, String company) {
        workRepo.updateCompany(idWork, company);
    }

    @Override
    public void updateJob(String idWork, String job) {
        workRepo.updateJob(idWork, job);
    }

    @Override
    public void updateStartDate(String idWork, Date sDate) {
        workRepo.updateStartdate(idWork, sDate);
    }

    @Override
    public void updateEnddate(String idWork, Date eDate) {
        workRepo.updateEnddate(idWork, eDate);
    }

    @Override
    public void updateIdPicture(String idWork, Picture idPicture) {
        workRepo.updateIdPicture(idWork, idPicture);
    }

}

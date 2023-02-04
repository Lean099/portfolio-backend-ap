package com.leandro.backend.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.leandro.backend.models.User;
import com.leandro.backend.models.Work;
import com.leandro.backend.repository.WorkRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
@Slf4j
public class WorkServiceImpl implements WorkService{
    
    private final WorkRepository workRepo;
    private final EntityManager entityManager;

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
    public List<Work> getAllUserWork(User idUser) {
        return workRepo.findAllByIdUser(idUser);
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
    public String deleteAllUserWork(User idUser) {
        workRepo.deleteAll(getAllUserWork(idUser));
        return "All deleted";
    }

    @Override
    public void updateIdUser(String idWork, String idUser) {
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
    public void updateIdPicture(String idWork, String idPicture) {
        workRepo.updateIdPicture(idWork, idPicture);
    }

}

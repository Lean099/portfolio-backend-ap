package com.leandro.backend.services;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.leandro.backend.models.Education;
import com.leandro.backend.models.User;
import com.leandro.backend.repository.EducationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
@Slf4j
public class EducationServiceImpl implements EducationService{
    
    private final EducationRepository educationRepo;
    private final EntityManager entityManager;

    @Override
    public Education savEducation(Education education, String idEducation) {
        education.setIdUser(entityManager.getReference(User.class, idEducation));
        return educationRepo.save(education);
    }

    @Override
    public Education getSingleEducation(String idEducation) {
        return educationRepo.findById(idEducation).get();
    }

    @Override
    public List<Education> getAllUserEducation(User idUser) {
        return educationRepo.findAllByIdUser(idUser);
    }

    @Override
    public String deleteEducation(String idEducation) {
        educationRepo.deleteById(idEducation);
        boolean isPresent = educationRepo.existsById(idEducation);
        if(isPresent){
            return "Could not be deleted";
        }
        return "Deleted successfully";
    }

    @Override
    public String deleteAllUserEducation(User idUser) {
        educationRepo.deleteAll(getAllUserEducation(idUser));
        return "All deleted";
    }

    @Override
    public void updateIdUser(String id, String idUser) {
        educationRepo.updateIdUser(id, idUser);
    }

    @Override
    public void updateInstitution(String id, String institution) {
        educationRepo.updateInstitution(id, institution);
    }

    @Override
    public void updateDegree(String id, String degree) {
        educationRepo.updateDegree(id, degree);
    }

    @Override
    public void updateEnddate(String id, Date enddate) {
        educationRepo.updateEnddate(id, enddate);
    }

    @Override
    public void updateIdPicture(String id, String idPicture) {
        educationRepo.updateIdPicture(id, idPicture);
    }

}

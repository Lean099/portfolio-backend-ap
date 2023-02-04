package com.leandro.backend.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.models.User;
import com.leandro.backend.models.Work;
import com.leandro.backend.services.WorkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WorkController {
    
    private final WorkService workService;

    @RequestMapping(value = "/work/create/{idUser}", method = RequestMethod.POST)
    public Work createWork(@PathVariable String idUser, @RequestBody Work work){ // Funciona
        return workService.saveWork(work, idUser);
    }

    @RequestMapping(value = "/work/{idWork}", method = RequestMethod.GET)
    public Work getSingleWork(@PathVariable String idWork){ // Funciona
        return workService.getWork(idWork);
    }

    @RequestMapping(value = "/work/all", method = RequestMethod.GET)
    public List<Work> getAllWork(@RequestBody User idUser){ // Funciona
        return workService.getAllUserWork(idUser);
    }

    @RequestMapping(value = "/work/update/{idWork}", method = RequestMethod.POST)
    public Work updateWork(@PathVariable String idWork, @RequestBody Work work){ // Funciona
        if(!Objects.isNull(work.getCompany())){
            workService.updateCompany(idWork, work.getCompany());
        }
        if(!Objects.isNull(work.getJob())){
            workService.updateJob(idWork, work.getJob());
        }
        if(!Objects.isNull(work.getStartdate()) && !Objects.isNull(work.getEnddate())){
            workService.updateStartDate(idWork, work.getStartdate());
            workService.updateEnddate(idWork, work.getEnddate());
        }
        return workService.getWork(idWork);
    }

    @RequestMapping(value = "/work/uploadPicture", method = RequestMethod.POST)
    public String uploadPicture(){
        return null;
    }

    @RequestMapping(value = "/work/delete/{idWork}", method = RequestMethod.DELETE) 
    public String deleteWork(@PathVariable String idWork){ // Funciona
        return workService.deleteWork(idWork);
    }

}

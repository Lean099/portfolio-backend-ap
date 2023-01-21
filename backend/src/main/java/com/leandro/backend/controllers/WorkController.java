package com.leandro.backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.models.Work;
import com.leandro.backend.services.WorkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WorkController {
    
    private final WorkService workService;

    @RequestMapping(value = "/work/create", method = RequestMethod.POST)
    public Work createWork(@RequestBody Work work){
        return null;
    }

    @RequestMapping(value = "/work/{idWork}", method = RequestMethod.GET)
    public Work getSingleWork(@PathVariable String idWork){
        return null;
    }

    @RequestMapping(value = "/work/all/{idUser}", method = RequestMethod.GET)
    public List<Work> getAllWork(@PathVariable String idUser){
        return null;
    }


}

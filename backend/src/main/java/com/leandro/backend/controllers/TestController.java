package com.leandro.backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.models.Test;
import com.leandro.backend.services.TestService;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    
    private final TestService testService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Test createData(@RequestBody Test test){
        return null;
    }

    @RequestMapping(value = "/getOne/{idData}", method = RequestMethod.GET)
    public Test getSingleData(@PathVariable String idData){
        return null;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Test> getAllData(){
        return null;
    }

}

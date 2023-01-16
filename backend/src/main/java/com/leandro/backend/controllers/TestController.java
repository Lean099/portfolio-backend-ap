package com.leandro.backend.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.leandro.backend.services.TestService;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    
    private final TestService testService;

}

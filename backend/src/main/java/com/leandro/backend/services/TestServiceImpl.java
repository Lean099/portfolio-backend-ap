package com.leandro.backend.services;

import org.springframework.stereotype.Service;

import com.leandro.backend.repository.TestRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
@Slf4j
public class TestServiceImpl implements TestService{
    
    private final TestRepository testRepo;

}

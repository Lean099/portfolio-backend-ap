package com.leandro.backend.services;

import org.springframework.stereotype.Service;

import com.leandro.backend.repository.EducationRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
@Slf4j
public class EducationServiceImpl implements EducationService{
    
    private final EducationRepository educationRepo;

}

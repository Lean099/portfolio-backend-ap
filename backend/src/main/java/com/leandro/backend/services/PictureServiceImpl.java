package com.leandro.backend.services;

import org.springframework.stereotype.Service;

import com.leandro.backend.repository.PictureRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
@Slf4j
public class PictureServiceImpl implements PictureService {
    
    private final PictureRepository pictureRepo;

}

package com.leandro.backend.services;

import org.springframework.stereotype.Service;

import com.leandro.backend.models.User;
import com.leandro.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@RequiredArgsConstructor 
@org.springframework.transaction.annotation.Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepo;

    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        return null;
    }

}

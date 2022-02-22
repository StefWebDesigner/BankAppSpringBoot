package com.stefwebdesigner.bankSpringBoot.beans.services;

import com.stefwebdesigner.bankSpringBoot.beans.entities.UserEntities;
import com.stefwebdesigner.bankSpringBoot.beans.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final userRepository userRepo;

    @Autowired
    public UserService(userRepository userRepo) {this.userRepo = userRepo;}


    public UserEntities getUserById(Integer userId) {
        return userRepo.findById(userId).get();
    }
}

package com.stefwebdesigner.bankSpringBoot.services;

import com.stefwebdesigner.bankSpringBoot.entities.UserEntities;
import com.stefwebdesigner.bankSpringBoot.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final userRepository userRepo;

    @Autowired
    public UserService(userRepository userRepo) {this.userRepo = userRepo;}

    //GETTING USERID
    public UserEntities getUserById(Integer userId) {
        return userRepo.findById(userId).get();
    }

    //SAVING NEW USER INFORMATION
    public UserEntities save(UserEntities user) {
        return userRepo.save(user);
    }



}

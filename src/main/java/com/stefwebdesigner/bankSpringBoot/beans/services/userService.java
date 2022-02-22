package com.stefwebdesigner.bankSpringBoot.beans.services;

import com.stefwebdesigner.bankSpringBoot.beans.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    private final userRepository userRepo;

    @Autowired
    public userService(userRepository userRepo) {this.userRepo = userRepo;}


}

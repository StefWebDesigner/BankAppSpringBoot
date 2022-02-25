package com.stefwebdesigner.bankSpringBoot.services;

import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.entities.UserModel;
import com.stefwebdesigner.bankSpringBoot.repositories.BankAccountRepository;
import com.stefwebdesigner.bankSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final BankAccountRepository bankAccountRepository;

    @Autowired
    public UserService(UserRepository userRepo, BankAccountRepository bankAccountRepository) {
        this.userRepo = userRepo;
        this.bankAccountRepository = bankAccountRepository;
    }

    //GETTING USERID
    public UserModel getUserById(Integer id) {
        Optional<UserModel> userOptional = userRepo.findById(id);
        return userOptional.orElse(null);
    }

    //SAVING NEW USER INFORMATION
    public UserModel save(UserModel userModel) {
        // create user in db
        UserModel savedUserModel = userRepo.save(userModel);
        // create a bank account for user
        BankAccountModel bankAccountModel = new BankAccountModel();
        bankAccountModel.setUserModel(savedUserModel);
        bankAccountModel.setCreatedDate(LocalDate.now());
        bankAccountModel.setType("SAVING");
        bankAccountModel.setAmount(0.0);
        bankAccountRepository.save(bankAccountModel);

        return savedUserModel;
    }

    public void delete(Integer id) {
        userRepo.deleteById(id);
    }


}

package com.stefwebdesigner.bankSpringBoot.services;

import com.stefwebdesigner.bankSpringBoot.entities.AccountType;
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
        //OPTIONAL IS NEEDED BECAUSE IF NULL IN THE CHANGE YOU DOUNLE CHECK
        //TO SEE IF IT HAS BEEN REMOVED---YOU GET A NULL
        //THIS IS A SHORTHAND OF DOING THAT
        return userOptional.orElse(null);
    }

    //SAVING NEW USER INFORMATION
    public UserModel save(UserModel userModel, String type) { // third parameter boolean requiresCredCard
        // TO CREATE A USER IN DB MARIA
        UserModel savedUserModel = userRepo.save(userModel);
        //CREATE A BANK ACCOUNT FOR THE USER
        //CONNECTING MY BANKACCOUNTMODEL TO USERMODEL
        BankAccountModel bankAccountModel = new BankAccountModel();
        bankAccountModel.setUserModel(savedUserModel);
        bankAccountModel.setCreatedDate(LocalDate.now());
        bankAccountModel.setAmount(0.0);

        //SPECIFTYING THE ACCOUNT WITH THE ENUM TYPE & NEWLY ADDED PARAMATER
        if (type.equals("CHECKING")) {
            bankAccountModel.setAccountType(AccountType.CHECKING);
        } else {
            bankAccountModel.setAccountType(AccountType.SAVING);
        }



        bankAccountRepository.save(bankAccountModel);


        // create credit card model

        return savedUserModel;
    }

    public void delete(Integer id) {
        userRepo.deleteById(id);
    }


}

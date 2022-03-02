package com.stefwebdesigner.bankSpringBoot.services;

import com.stefwebdesigner.bankSpringBoot.entities.AccountType;
import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.entities.CreditCardModel;
import com.stefwebdesigner.bankSpringBoot.entities.UserModel;
import com.stefwebdesigner.bankSpringBoot.repositories.BankAccountRepository;
import com.stefwebdesigner.bankSpringBoot.repositories.CreditCardRepository;
import com.stefwebdesigner.bankSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final BankAccountRepository bankAccountRepository;
    private final CreditCardRepository creditCardRepository;

    @Autowired
    public UserService(UserRepository userRepo, BankAccountRepository bankAccountRepository, CreditCardRepository creditCardRepository) {
        this.userRepo = userRepo;
        this.bankAccountRepository = bankAccountRepository;
        this.creditCardRepository = creditCardRepository;
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
    //TODO: ADD A THIRD BOOLEAN CREDIT PARAMETER
    public UserModel save(UserModel userModel, String type, Boolean requiresCard) { // third parameter boolean requiresCredCard
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

//        CreditCardModel creditCardModel = new CreditCardModel();
//        creditCardModel.setBankAccountModel(bankAccountModel);
//        //GENERATES RANDOM NUMBER FOR CREDIT CARDS
//        Random random = new Random();
//        creditCardModel.setCreditCardNumber(random.nextLong());
//        creditCardModel.setLimit(3000);

        //TODO: ADD IF CONDITION IF CREDIT CARD IS TRUE
        if(requiresCard) {
            CreditCardModel creditCardModel = new CreditCardModel();
            creditCardModel.setBankAccountModel(bankAccountModel);
            //GENERATES RANDOM NUMBER FOR CREDIT CARDS
            Random random = new Random();
            creditCardModel.setCreditCardNumber(random.nextLong());
            creditCardModel.setLimit(3000);
            creditCardRepository.save(creditCardModel);
        } else {
            return null;
        }

        return savedUserModel;
    }

    public void delete(Integer id) {
        userRepo.deleteById(id);
    }


}

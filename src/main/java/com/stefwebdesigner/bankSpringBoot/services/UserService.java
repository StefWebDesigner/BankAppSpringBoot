package com.stefwebdesigner.bankSpringBoot.services;

import com.stefwebdesigner.bankSpringBoot.entities.*;
import com.stefwebdesigner.bankSpringBoot.repositories.BankAccountRepository;
import com.stefwebdesigner.bankSpringBoot.repositories.CreditCardNumberRepository;
import com.stefwebdesigner.bankSpringBoot.repositories.CreditCardRepository;
import com.stefwebdesigner.bankSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final BankAccountRepository bankAccountRepository;
    private final CreditCardRepository creditCardRepository;
    private final CreditCardNumberRepository creditCardNumberRepository;

    @Autowired
    public UserService(UserRepository userRepo, BankAccountRepository bankAccountRepository, CreditCardRepository creditCardRepository, CreditCardNumberRepository creditCardNumberRepository) {
        this.userRepo = userRepo;
        this.bankAccountRepository = bankAccountRepository;
        this.creditCardRepository = creditCardRepository;
        this.creditCardNumberRepository = creditCardNumberRepository;
    }

    public UserModel login(String username, String password) {
        Optional<UserModel> userModel = userRepo.findByUsername(username);
        if(userModel.isPresent()) {
            if(userModel.get().getPassword().equals(password)) {
                return userModel.get();
            }
        }
        return null;
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

        //FOR PROMPTING AND SAVING OF CREDIT CARD MODAL
        CreditCardModel creditCardModel = new CreditCardModel();

        if(requiresCard) {
//            CreditCardModel creditCardModel = new CreditCardModel();
            creditCardModel.setBankAccountModel(bankAccountModel);
            Optional<CreditCardNumber> creditCardNumber = creditCardNumberRepository.findById(1L);
            creditCardModel.setCreditCardNumber(creditCardNumber.get().getNumber());
            creditCardNumber.get().setNumber(creditCardNumber.get().getNumber() + 1);
            creditCardNumberRepository.save(creditCardNumber.get());

            if(type.equals("CHECKING")){
                creditCardModel.setMoneyLimit(3000);
            } else {
                creditCardModel.setMoneyLimit(1000);
            }
            creditCardRepository.save(creditCardModel);
        }
        return savedUserModel;
    }

    public void delete(Integer id) {
        userRepo.deleteById(id);
    }


}


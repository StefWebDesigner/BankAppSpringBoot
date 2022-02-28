package com.stefwebdesigner.bankSpringBoot.services;

import com.stefwebdesigner.bankSpringBoot.entities.AccountType;
import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.entities.UserModel;
import com.stefwebdesigner.bankSpringBoot.repositories.BankAccountRepository;
import com.stefwebdesigner.bankSpringBoot.repositories.UserRepository;
import org.apache.catalina.webresources.ClasspathURLStreamHandler;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@Service
public class BankService {

    private final BankAccountRepository bankRepository;
    private final UserRepository userRepository;

    @Autowired
    public BankService(BankAccountRepository bankRepository, UserRepository userRepository) {
        this.bankRepository = bankRepository;
        this.userRepository = userRepository;
    }

    //TO GET A SPECIFIC BANK ACCOUNT BY ID
    public List<BankAccountModel> getBankAccountDetails(Integer userId) {
        Optional<UserModel> user = userRepository.findById(userId);
        return user.map(bankRepository::findByUserModel).orElse(null);
    }

    //TO DEPOSIT MONEY TO AN ACCOUNT
    public String saveDeposit(Integer bankId, Double amount) throws NoSuchFieldException {
        Optional<BankAccountModel> bank =  bankRepository.findById(bankId);
        try {
            if (bank.isPresent()) {
                Double currentAmount = bank.get().getAmount();
                currentAmount = currentAmount + amount;
                bank.get().setAmount(currentAmount);
                bankRepository.save(bank.get());
            }
        } catch(Exception e){
                throw new NoSuchFieldException("No bank id detected");
            }
        return "Amount has been deposited";

    }

//    public String saveDeposit(Integer bankId, Double amount) {
//        Optional<BankAccountModel> bank =  bankRepository.findById(bankId);
//        if(bank.isPresent()) {
//            Double currentAmount = bank.get().getAmount();
//            currentAmount = currentAmount + amount;
//            bank.get().setAmount(currentAmount);
//            bankRepository.save(bank.get());
//            return "Amount has been deposited";
//        } else {
//
//            return "Bank ID is wrong";
//        }
//    }



    //TO WITHDRAW MONEY OUT OF AN SPECIFIC ACCOUNT
    //TODO: ADD MORE CONDITIONS SO IT CAN'T GO INTO ITS OVERDRAFT
    public String saveWithdraw(Integer bankId, Double amount) {
        Optional<BankAccountModel> bank = bankRepository.findById(bankId);
        if(bank.isPresent()) {
            Double currentAmount = bank.get().getAmount();
            currentAmount = currentAmount - amount;
            if (currentAmount >= amount) {
                bank.get().setAmount(currentAmount);
                bankRepository.save(bank.get());
            } else {
                System.out.println("withdraw has reached withdraw overdraft net");
                return null;
            }
            return "Withdraw is successful";
        } else {
            System.out.println("Bank was not present");
            return null;
        }

    }

    //TO RETRIEVE ALL BANK ACCOUNT
    public List<BankAccountModel> getAllAccounts() {
        List<BankAccountModel> getAllAccounts = bankRepository.findAll();
        return getAllAccounts;
    }

    //TO RETRIEVE ALL ACCOUNT BY DATE
    //TODO: FIX THE PARSE BUG WHEN EXECUTING THE REQUEST
//    public List<BankAccountModel> getAccountsByDate(LocalDate createDate) {
//        List<BankAccountModel> getAccountsByDate = bankRepository.findAll();
//        return getAccountsByDate(createDate);
//    }

    //TO RETRIEVE ALL ACCOUNT BY BANK ACCOUNT
    //TODO: FIX THE PARSE BUG WHEN EXECUTING THE REQUEST
//    public List<BankAccountModel> getAccountsByType(AccountType accountType) {
//        List<BankAccountModel> getAccountsByType = bankRepository.findAll();
//        if(accountType.equals("CHECKING")) {
//            return getAccountsByType(AccountType.CHECKING);
//        } else {
//            return getAccountsByType(AccountType.SAVING);
//        }
//    }

}

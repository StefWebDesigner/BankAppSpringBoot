package com.stefwebdesigner.bankSpringBoot.services;

import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.entities.UserModel;
import com.stefwebdesigner.bankSpringBoot.repositories.BankAccountRepository;
import com.stefwebdesigner.bankSpringBoot.repositories.UserRepository;
import org.apache.catalina.webresources.ClasspathURLStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public List<BankAccountModel> getBankAccountDetails(Integer userId) {
        Optional<UserModel> user = userRepository.findById(userId);
        return user.map(bankRepository::findByUserModel).orElse(null);
    }

    public String saveDeposit(Integer bankId, Double amount) {

        Optional<BankAccountModel> bank =  bankRepository.findById(bankId);
        if(bank.isPresent()) {
            Double currentAmount = bank.get().getAmount();
            currentAmount = currentAmount + amount;
            bank.get().setAmount(currentAmount);
            bankRepository.save(bank.get());
            return "Amount has been deposited";
        } else {

            return "Bank ID is wrong";
        }
    }


    //TODO: ADD MORE CONDITIONS SO IT CAN'T GO INTO ITS OVERDRAFT
    public String saveWithdraw(Integer bankId, Double amount) {

        Optional<BankAccountModel> bank = bankRepository.findById(bankId);
        if(bank.isPresent()) {
            Double currentAmount = bank.get().getAmount();
            currentAmount = currentAmount - amount;
            bank.get().setAmount(currentAmount);
            bankRepository.save(bank.get());
            return "Withdraw is successful";
        } else {
            return "Withdraw failed";
        }

    }


    public List<BankAccountModel> getAllAccounts() {
        List<BankAccountModel> getAllAccounts = bankRepository.findAll();
        return getAllAccounts;
    }

    public List<BankAccountModel> getAccountByDate(LocalDate createDate) {
        List<BankAccountModel> getAccountByDate = bankRepository.findAll();


        return getAccountByDate(createDate);
    }


}

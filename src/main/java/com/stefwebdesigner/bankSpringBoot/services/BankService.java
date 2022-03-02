package com.stefwebdesigner.bankSpringBoot.services;

import com.stefwebdesigner.bankSpringBoot.entities.AccountType;
import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.entities.UserModel;
import com.stefwebdesigner.bankSpringBoot.repositories.BankAccountRepository;
import com.stefwebdesigner.bankSpringBoot.repositories.UserRepository;
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

    //TO GET A SPECIFIC BANK ACCOUNT BY ID
    public List<BankAccountModel> getBankAccountDetails(Integer userId) {
        Optional<UserModel> user = userRepository.findById(userId);
        return user.map(bankRepository::findByUserModel).orElse(null);
    }

    //TO DEPOSIT MONEY TO AN ACCOUNT
    public String saveDeposit(Integer bankId, Double amount) throws NoSuchFieldException {
        Optional<BankAccountModel> bank = bankRepository.findById(bankId);
        try {
            if (bank.isPresent()) {
                Double currentAmount = bank.get().getAmount();
                currentAmount = currentAmount + amount;
                bank.get().setAmount(currentAmount);
                bankRepository.save(bank.get());
            }
        } catch (Exception e) {
            throw new NoSuchFieldException("No bank id detected");
        }
        return "Amount has been deposited";

    }

    public String saveWithdraw(Integer bankId, Double amount) throws Exception {
        Optional<BankAccountModel> bank = bankRepository.findById(bankId);
        try {
            if (bank.isPresent()) {
                try {
                    Double currentAmount = bank.get().getAmount();
                    currentAmount = currentAmount - amount;
                    if (currentAmount >= amount) {
                        bank.get().setAmount(currentAmount);
                        bankRepository.save(bank.get());
                        return "Withdraw is successful";
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("withdraw has reached withdraw overdraft net");
                    return "withdraw has reached withdraw overdraft net";
                }
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Bank was not present");
            return "Bank Not present";
        }

    }


    //TO RETRIEVE ALL BANK ACCOUNT
    public List<BankAccountModel> getAllAccounts() {
        return bankRepository.findAll();
    }

    //TO RETRIEVE ALL ACCOUNT BY DATE
    public List<BankAccountModel> getAccountsByDate(LocalDate createDate) {
        return bankRepository.findByCreatedDate(createDate);
    }

    //TO RETRIEVE ALL ACCOUNT BY BANK ACCOUNT
    public List<BankAccountModel> getAccountsByType(AccountType accountType) {
        return bankRepository.findByAccountType(accountType);
    }

}

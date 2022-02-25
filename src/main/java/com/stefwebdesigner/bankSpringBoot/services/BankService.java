package com.stefwebdesigner.bankSpringBoot.services;

import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.entities.UserModel;
import com.stefwebdesigner.bankSpringBoot.repositories.BankAccountRepository;
import com.stefwebdesigner.bankSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (!user.isPresent()) {
            return null;
        }
        return bankRepository.findByUserModel(user.get());
    }
}

package com.stefwebdesigner.bankSpringBoot.services;

import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.entities.CreditCardModel;
import com.stefwebdesigner.bankSpringBoot.repositories.BankAccountRepository;
import com.stefwebdesigner.bankSpringBoot.repositories.CreditCardRepository;
import com.stefwebdesigner.bankSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

    private final BankAccountRepository bankAccountRepository;
    private final CreditCardRepository creditCardRepository;

    @Autowired
    public CreditCardService(BankAccountRepository bankAccountRepository, CreditCardRepository creditCardRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.creditCardRepository = creditCardRepository;
    }

    public List<CreditCardModel> getCreditCardDetails(Integer bankId) {
        Optional<BankAccountModel> bankUser = bankAccountRepository.findById(bankId);
        return bankUser.map(creditCardRepository::findByBankAccountModel).orElse(null);
    }
}

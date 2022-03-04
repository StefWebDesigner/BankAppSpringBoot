package com.stefwebdesigner.bankSpringBoot.repositories;

import com.stefwebdesigner.bankSpringBoot.entities.AccountType;
import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.entities.CreditCardModel;
import com.stefwebdesigner.bankSpringBoot.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountModel, Integer> {

    List<BankAccountModel> findByUserModel(UserModel userModel);
    List<BankAccountModel> findByCreatedDate(LocalDate createdDate);
    List<BankAccountModel> findByAccountType(AccountType accountType);


//     List<CreditCardModel> findByBankModel(BankAccountModel bankAccountModel);
}

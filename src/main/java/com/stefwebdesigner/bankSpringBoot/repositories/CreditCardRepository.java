package com.stefwebdesigner.bankSpringBoot.repositories;

import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.entities.CreditCardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardModel, Integer> {

    List<CreditCardModel> findByBankAccountModel (BankAccountModel bankAccountModel);


}

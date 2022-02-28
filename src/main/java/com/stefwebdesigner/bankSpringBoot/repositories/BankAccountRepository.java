package com.stefwebdesigner.bankSpringBoot.repositories;

import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountModel, Integer> {
    List<BankAccountModel> findByUserModel(UserModel userModel);

}

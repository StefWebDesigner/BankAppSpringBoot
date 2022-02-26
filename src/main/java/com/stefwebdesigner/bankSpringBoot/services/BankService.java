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

    //***I'M THINKING TO JUST SCRAP ALL THIS AND TRY AGAIN ***

    public List<BankAccountModel> getBankAccountDetails(Integer userId) {
        Optional<UserModel> user = userRepository.findById(userId);
        return user.map(bankRepository::findByUserModel).orElse(null);
    }

    public List<BankAccountModel> saveDeposit(BankAccountModel bankAccountModel) {
        BankAccountModel saveDeposit = bankRepository.save(bankAccountModel);

        bankAccountModel.setUserModel(new UserModel());
        bankAccountModel.setAmount();
        bankAccountModel.setCheckAccount("");
        bankAccountModel.setSavingAccount("");

        return (List<BankAccountModel>) saveDeposit;
    }

    public List<BankAccountModel> saveWithdraw(BankAccountModel bankAccountModel) {
        BankAccountModel saveWithdraw = bankRepository.save(bankAccountModel);

        bankAccountModel.setUserModel(new UserModel());
        bankAccountModel.setAmount();
        bankAccountModel.setCheckAccount("");
        bankAccountModel.setSavingAccount("");

        return (List<BankAccountModel>) saveWithdraw;
    }




//    //should it be wrapped with the list
//    public  List<BankAccountModel> saveDepositChecking(BankAccountModel bankAccountModel) {
//        BankAccountModel saveDeposit = bankRepository.save(bankAccountModel);
//        bankAccountModel.setBankAccountModel(saveDeposit);
//        bankAccountModel.setAmount();
//        bankAccountModel.setCheckAccount("");
//
//         bankRepository.save(bankAccountModel);
//
//        return (List<BankAccountModel>) saveDeposit;
//    }






//    public BankAccountModel saveDepositChecking (BankAccountModel bankAccountModel) {
//        UserModel savedDepositModel = bankRepository(userModel);
//        bankAccountModel = new BankAccountModel();
//        bankRepository.setCheckAccount();
//
//        bankRepository.save(bankAccountModel);
//
//        return savedDepositModel;
//    }

}

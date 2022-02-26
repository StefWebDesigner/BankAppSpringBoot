package com.stefwebdesigner.bankSpringBoot.controller;

import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class BankController {
    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }


    //GET THE ACCOUNT NEEDED ()

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getDepositeAccount(@PathVariable("id") Integer userId) {
        List<BankAccountModel> result = bankService.getBankAccountDetails(userId);
        if (result == null) {
            return ResponseEntity.ok("User id is wrong");
        }
        return ResponseEntity.ok("Successfuy");
    }


    //THE GENERIC DEPOSIT REQUEST
    //TODO: ADD CONDITIONS TO SPECIFY WHICH ACCOUNT
    @RequestMapping(value = "/account/deposit", method = RequestMethod.POST)
    public ResponseEntity<List<BankAccountModel>> saveDeposit(@RequestBody BankAccountModel bankAccountModel) {
        return ResponseEntity.ok(bankService.saveDeposit(bankAccountModel));
    }

    //THE GENERIC WITHDRAW REQUEST
    //TODO: ADD CONDITIONS TO SPECIFY WHICH ACCOUNT
    @RequestMapping(value = "/account/withdraw", method = RequestMethod.POST)
    public ResponseEntity <List<BankAccountModel>> saveWithdraw(@RequestBody BankAccountModel bankAccountModel) {
        return ResponseEntity.ok(bankService.saveWithdraw(bankAccountModel));
    }

    //TODO: ADD THE SHOW ALL CURRENT ACCOUNT
    @RequestMapping(value = "/account/displayaccounts", method = RequestMethod.POST)
    public ResponseEntity <List<BankAccountModel>> showAllAccount()

}

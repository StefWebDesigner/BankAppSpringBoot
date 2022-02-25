package com.stefwebdesigner.bankSpringBoot.controller;

import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok(result);
    }

    //TODO: ADD THE POST DEPOSIT CHECKING METHOD





    //TODO: ADD THE POST DEPOSIT SAVING METHOD

    //TODO: ADD THE POST WITHDRAW CHECKING METHOD

    //TODO: ADD THE POST WITHDRAW SAVING METHOD


}

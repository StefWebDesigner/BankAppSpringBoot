package com.stefwebdesigner.bankSpringBoot.controller;

import com.stefwebdesigner.bankSpringBoot.entities.BankAccountModel;
import com.stefwebdesigner.bankSpringBoot.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BankController {
    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    //GET THE ACCOUNT NEEDED ()
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAccount(@PathVariable("id") Integer userId) {
        List<BankAccountModel> result = bankService.getBankAccountDetails(userId);
        if (result == null) {
            return ResponseEntity.ok("User id is wrong");
        }
        return ResponseEntity.ok("Successfuy");
    }

    //THE  DEPOSIT REQUEST
//    localhost:8080/account/deposit?id=9&amount=50.0
    @RequestMapping(value = "/account/deposit", method = RequestMethod.POST)
    public ResponseEntity<String> saveDeposit(@RequestParam("id") Integer bankId, @RequestParam("amount") Double amount) {
        return ResponseEntity.ok(bankService.saveDeposit(bankId, amount));
    }

    //STRING
    //THE  WITHDRAW REQUEST
    @RequestMapping(value = "/account/withdraw", method = RequestMethod.POST)
    public ResponseEntity <String> saveWithdraw(@RequestParam("id") Integer bankId, @RequestParam("amount") Double amount) {
        return ResponseEntity.ok(bankService.saveWithdraw(bankId, amount));
    }

    //GET ALL ACCOUNT
    @RequestMapping(value = "/account/all", method = RequestMethod.GET)
    public ResponseEntity<List<BankAccountModel>> getAllAccounts() {
        return ResponseEntity.ok(bankService.getAllAccounts());
    }

    //GET ALL ACCOUNT BY DATE
    @RequestMapping(value = "/account/date", method = RequestMethod.GET)
    public ResponseEntity<List<BankAccountModel>> getAccountByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate createDate) {
        return ResponseEntity.ok(bankService.getAccountByDate(createDate));
    }

//2022-02-28


}

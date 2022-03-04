package com.stefwebdesigner.bankSpringBoot.controller;


import com.stefwebdesigner.bankSpringBoot.entities.CreditCardModel;
import com.stefwebdesigner.bankSpringBoot.services.CreditCardService;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditCardController {
    private final CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {this.creditCardService = creditCardService;}

    @RequestMapping(value = "creditcard/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBankAccount(@PathVariable("id") Integer bankId) {
        List<CreditCardModel> result = creditCardService.getCreditCardDetails(bankId);

        if(result == null) {
            return ResponseEntity.ok("Couldn't find the Id");
        }

        return ResponseEntity.ok(result);
    }



}

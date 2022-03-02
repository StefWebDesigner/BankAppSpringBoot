package com.stefwebdesigner.bankSpringBoot.entities;

import javax.persistence.*;
import java.util.Iterator;

@Entity
public class CreditCardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Long creditCardNumber;
    private Integer limit;
    private BankAccountModel bankAccountModel;


    //TODO: ENCOUNTERED AN ERROR --- MAY NEED TO CONNECT IT WITH MANY TO ONLY THING


    public CreditCardModel () {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public BankAccountModel getBankAccountModel() {
        return bankAccountModel;
    }

    public void setBankAccountModel(BankAccountModel bankAccountModel) {
        this.bankAccountModel = bankAccountModel;
    }
}
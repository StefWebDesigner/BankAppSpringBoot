package com.stefwebdesigner.bankSpringBoot.entities;

import javax.persistence.*;

@Entity
public class CreditCardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer creditCardModelId;
    private Long creditCardNumber;
    private Integer moneyLimit;

    @ManyToOne
    BankAccountModel bankAccountModel;

    public Integer getCreditCardModelId() {
        return creditCardModelId;
    }

    public void setCreditCardModelId(Integer creditCardModelId) {
        this.creditCardModelId = creditCardModelId;
    }

    public Long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(Long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Integer getMoneyLimit() {
        return moneyLimit;
    }

    public void setMoneyLimit(Integer moneyLimit) {
        this.moneyLimit = moneyLimit;
    }

    public BankAccountModel getBankAccountModel() {
        return bankAccountModel;
    }

    public void setBankAccountModel(BankAccountModel bankAccountModel) {
        this.bankAccountModel = bankAccountModel;
    }
}
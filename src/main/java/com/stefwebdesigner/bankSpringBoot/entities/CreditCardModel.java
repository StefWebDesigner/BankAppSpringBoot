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
    private Boolean requiredCard;

    @ManyToOne
    BankAccountModel bankAccountModel;

    public CreditCardModel() {
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

    public Boolean getRequiredCard() {
        return requiredCard;
    }

    public void setRequiredCard(Boolean requiredCard) {
        this.requiredCard = requiredCard;
    }
}
package com.stefwebdesigner.bankSpringBoot.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BankAccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bankAccountModelId;
    private double amount;
    private LocalDate createdDate;
    private AccountType accountType;


    //ESTABLISHES THE TABLE RELATION BETWEEN THE TWO TABLES
    @ManyToOne
    UserModel userModel;


    public BankAccountModel() {
    }

    public Integer getBankAccountModelId() {
        return bankAccountModelId;
    }

    public void setBankAccountModelId(Integer bankAccountModelId) {
        this.bankAccountModelId = bankAccountModelId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
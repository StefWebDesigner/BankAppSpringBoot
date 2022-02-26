package com.stefwebdesigner.bankSpringBoot.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BankAccountModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String savingAccount;
    private String checkAccount;
    private double amount;
    private LocalDate createdDate;

    //TRANSACTIONAL OBJECTS
    @Column
    private double depositChecking;
    @Column
    private double depositSaving;
    @Column
    private double withdrawChecking;
    @Column
    private double withdrawSaving;

    //ESTABLISHES THE TABLE RELATION BETWEEN THE TWO TABLES
    @ManyToOne
    UserModel userModel;

//    private BankAccountModel bankAccountModel; //I ADDED THIS

    public BankAccountModel() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(String savingAccount) {
        this.savingAccount = savingAccount;
    }

    public String getCheckAccount() {
        return checkAccount;
    }

    public void setCheckAccount(String checkAccount) {
        this.checkAccount = checkAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount() { //IT ORIGINALLY HAD AN DOUBLE AMOUNT
        this.amount = amount;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
//
//    public BankAccountModel getBankAccountModel() {
//        return bankAccountModel;
//    }
//
//    public void setBankAccountModel(BankAccountModel bankAccountModel) {
//        this.bankAccountModel = bankAccountModel;
//    }



    //TRANSACTIONAL GETTERS AND SETTERS


    public double getDepositChecking() {
        return depositChecking;
    }

    public void setDepositChecking(double depositChecking) {
        this.depositChecking = depositChecking;
    }

    public double getDepositSaving() {
        return depositSaving;
    }

    public void setDepositSaving(double depositSaving) {
        this.depositSaving = depositSaving;
    }

    public double getWithdrawChecking() {
        return withdrawChecking;
    }

    public void setWithdrawChecking(double withdrawChecking) {
        this.withdrawChecking = withdrawChecking;
    }

    public double getWithdrawSaving() {
        return withdrawSaving;
    }

    public void setWithdrawSaving(double withdrawSaving) {
        this.withdrawSaving = withdrawSaving;
    }

}

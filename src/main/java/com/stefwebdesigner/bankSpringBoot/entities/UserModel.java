package com.stefwebdesigner.bankSpringBoot.entities;

import javax.persistence.*;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;

//    @OneToMany
//    BankAccountModel bankAccountModel;
//    CreditCardModel creditCardModel;

    //YOU WANT OVER THE DEFAULT CONSTRUCTOR
    public UserModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//  EXPERIMENTAL STUFF

//    public BankAccountModel getBankAccountModel() {
//        return bankAccountModel;
//    }
//
//    public void setBankAccountModel(BankAccountModel bankAccountModel) {
//        this.bankAccountModel = bankAccountModel;
//    }
//
//    public CreditCardModel getCreditCardModel() {
//        return creditCardModel;
//    }
//
//    public void setCreditCardModel(CreditCardModel creditCardModel) {
//        this.creditCardModel = creditCardModel;
//    }
}

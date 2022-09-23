package com.dmeritano.patrones.estructurales.decorator;

import com.dmeritano.patrones.estructurales.decorator.model.Account;

public class SavingsAccountImpl implements IAccount {

    @Override
    public void open(Account account) {
        System.out.println("******************************");
        System.out.println("Savings account successfully open");
        System.out.println("Client: " + account.getClient().getFullName());
    }
}

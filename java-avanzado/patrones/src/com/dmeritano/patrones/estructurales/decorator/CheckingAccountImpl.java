package com.dmeritano.patrones.estructurales.decorator;

import com.dmeritano.patrones.estructurales.decorator.IAccount;
import com.dmeritano.patrones.estructurales.decorator.model.Account;

public class CheckingAccountImpl implements IAccount {

    @Override
    public void open(Account account) {
        System.out.println("******************************");
        System.out.println("Checking account successfully open");
        System.out.println("Client: " + account.getClient().getFullName());
    }
}

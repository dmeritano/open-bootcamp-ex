package com.dmeritano.patrones.estructurales.decorator;

import com.dmeritano.patrones.estructurales.decorator.model.Account;

public class AccountInsurance extends AccountDecorator{

    public AccountInsurance(IAccount decoratedAccount){
        super(decoratedAccount);
    }

    @Override
    public void open(Account account){
        decoratedAccount.open(account);
        addInsurance(account);
    }

    public void addInsurance(Account account) {
        String temp = String.format("Added basic insurance to account %s, client: %s", account.getCbu(),
                account.getClient().getFullName());
        System.out.println(temp);
    }
}

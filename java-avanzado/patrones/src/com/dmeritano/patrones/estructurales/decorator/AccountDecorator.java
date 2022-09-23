package com.dmeritano.patrones.estructurales.decorator;

import com.dmeritano.patrones.estructurales.decorator.model.Account;

public abstract class AccountDecorator implements IAccount{

    protected IAccount decoratedAccount;

    public AccountDecorator(IAccount decoratedAccount){
        this.decoratedAccount = decoratedAccount;
    }

    @Override
    public void open(Account account){
        this.decoratedAccount.open(account);;
    }


}

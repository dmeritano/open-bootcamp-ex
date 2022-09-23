package com.dmeritano.patrones.estructurales.decorator;

import com.dmeritano.patrones.estructurales.decorator.model.Account;
import com.dmeritano.patrones.estructurales.decorator.model.Client;

public class Main {

    public static void main(String[] args) {

        //Open saving account with insurance
        Client client = new Client(1, "23012343", "David Meritano");
        Account account = new Account("012546841354133","davn.1000", client);

        IAccount savingAccount = new SavingsAccountImpl();
        IAccount accountInsurance = new AccountInsurance(savingAccount);

        accountInsurance.open(account);


        //Open checking account without insurance
        Client client2 = new Client(2, "32456888", "Josefa Gomez");
        Account account2 = new Account("727254689877878","ceno.tex", client2);

        IAccount checkingAccount = new CheckingAccountImpl();
        checkingAccount.open(account2);

        //Open checking account with insurance
        Client client3 = new Client(3, "480023243", "Daniel San");
        Account account3 = new Account("00001232453299999","daniel.san.10", client3);

        IAccount accountInsurance2 = new AccountInsurance(new CheckingAccountImpl());
        accountInsurance2.open(account3);




    }
}

package com.dmeritano.patrones.estructurales.decorator.model;

public class Account {

    private String cbu;
    private String alias;
    private Client client;

    public Account() {
    }

    public Account(String cbu, String alias, Client client) {
        this.cbu = cbu;
        this.alias = alias;
        this.client = client;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

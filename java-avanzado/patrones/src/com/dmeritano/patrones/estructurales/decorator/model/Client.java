package com.dmeritano.patrones.estructurales.decorator.model;

public class Client {

    private int id;
    private String personalId;
    private String fullName;

    public Client(int id, String personalId, String fullName) {
        this.id = id;
        this.personalId = personalId;
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}

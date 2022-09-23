package com.dmeritano.patrones.estructurales.adapter;

public class Lightbulb {

    private boolean poweredOn = false;
    private int voltage = 0;

    public void turnOn(int voltage){
        poweredOn = true;
        this.voltage = voltage;
    }

    public void turnOff(){
        poweredOn = false;
        voltage = 0;
    }

    public  boolean isPoweredOn(){
        return poweredOn;
    }
}

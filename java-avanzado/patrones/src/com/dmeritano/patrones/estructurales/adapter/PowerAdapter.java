package com.dmeritano.patrones.estructurales.adapter;

public class PowerAdapter implements Enchufable {

    public Lightbulb lightbulb = new Lightbulb();

    @Override
    public String identificador() {
        //Lightbulb no permite establecer ni setear su nombre
        return "Lightbulb";
    }

    @Override
    public void enciende() {
        lightbulb.turnOn(110);
    }

    @Override
    public void apaga() {
        lightbulb.turnOff();
    }

    @Override
    public boolean estaEncendido() {
        return lightbulb.isPoweredOn();
    }


}

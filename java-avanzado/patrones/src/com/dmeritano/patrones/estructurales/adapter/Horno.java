package com.dmeritano.patrones.estructurales.adapter;

public class Horno implements Enchufable{

    private String idDispositivo;
    private boolean encendido = false;

    public Horno(String idDispositivo){
        this.idDispositivo = idDispositivo;
    }

    @Override
    public String identificador() {
        return idDispositivo;
    }

    @Override
    public void enciende() {
        encendido = true;
    }

    @Override
    public void apaga() {
        encendido = false;
    }

    @Override
    public boolean estaEncendido() {
        return encendido;
    }
}

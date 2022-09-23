package com.dmeritano.patrones.estructurales.adapter;

public class Lampara implements Enchufable{

    private String nombreLampara;
    private final String nombre = "Horno";
    private boolean encendido = false;


    public Lampara(String nombreLampara){
        this.nombreLampara = nombreLampara;
    }

    @Override
    public String identificador() {
        return nombreLampara;
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

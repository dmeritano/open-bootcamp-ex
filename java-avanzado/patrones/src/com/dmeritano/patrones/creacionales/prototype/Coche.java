package com.dmeritano.patrones.creacionales.prototype;

public class Coche {

    public String marca;
    public String modelo;
    public int puertas;

    public Coche(){}

    public Coche clonar(){
        Coche clon = new Coche();
        clon.marca = marca;
        clon.modelo = modelo;
        clon.puertas = puertas;

        return clon;
    }


    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", puertas=" + puertas +
                '}';
    }
}

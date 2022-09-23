package com.dmeritano.patrones.creacionales.builder;

public class Vehiculo {

    public String marca;
    public String motor;
    public int puertas;

    public String getMarca() {
        return marca;
    }

    public String getMotor() {
        return motor;
    }

    public int getPuertas() {
        return puertas;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", motor='" + motor + '\'' +
                ", puertas=" + puertas +
                '}';
    }
}

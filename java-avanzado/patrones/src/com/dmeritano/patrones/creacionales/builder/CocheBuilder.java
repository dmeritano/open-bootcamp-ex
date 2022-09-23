package com.dmeritano.patrones.creacionales.builder;

public class CocheBuilder {

    private Vehiculo vehiculo;
    public CocheBuilder(String marca){
        vehiculo = new Vehiculo();
        vehiculo.marca = marca;
    }

    public CocheBuilder setMotor(String motor){
        vehiculo.motor = motor;
        return this;
    }

    public CocheBuilder setPuertas(int puertas){
        vehiculo.puertas = puertas;
        return this;
    }

    public Vehiculo build(){
        return this.vehiculo;
    }


}

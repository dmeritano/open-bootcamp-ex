package com.dmeritano.patrones.creacionales.builder;

public class Main {

    public static void main(String[] args) {

        Vehiculo coche = new CocheBuilder("Fiat")
                .setPuertas(5)
                .setMotor("Electrico")
                .build();

        System.out.println(coche);
    }

}

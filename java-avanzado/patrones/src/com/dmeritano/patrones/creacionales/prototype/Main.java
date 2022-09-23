package com.dmeritano.patrones.creacionales.prototype;

public class Main {

    public static void main(String[] args) {

        //Clonado manual

        Coche coche = new Coche();
        coche.puertas = 5;
        coche.marca = "Fiat";
        coche.modelo ="Uno";

        System.out.println(coche);
        Coche clonado = coche.clonar();
        System.out.println(clonado);

        //Clonado con Cloneable
        Moto moto = new Moto();
        moto.marca = "Ducati";
        moto.model = "X250";

        System.out.println(moto);
        Moto motoClonada = null;
        try {
            motoClonada = moto.clonar();
            System.out.println(motoClonada);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }



    }
}

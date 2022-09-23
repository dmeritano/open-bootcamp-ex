package com.dmeritano.patrones.estructurales.adapter;

public class Main {

    public static void main(String[] args) {


        Horno horno = new Horno("Horno LG2022");
        Lampara lampara = new Lampara("Lampara X10");
        PowerAdapter lightbulb = new PowerAdapter();

        //Encendemos los 3
        enciende(horno);
        enciende(lampara);
        enciende(lightbulb);

        if (estaEncdendido(horno)){
            System.out.println("Apagando " + horno.identificador());
            apaga(horno);
        }

        if (estaEncdendido(lampara)){
            System.out.println("Apagando " + lampara.identificador());
            apaga(lampara);
        }

        if (estaEncdendido(lightbulb)){
            System.out.println("Apagando " + lightbulb.identificador());
            apaga(lightbulb);
        }


    }

    public static void enciende(Enchufable enchufable){
        enchufable.enciende();
        System.out.println(enchufable.identificador() + " encendido");
    }

    public static void apaga(Enchufable enchufable){
        enchufable.apaga();
        System.out.println(enchufable.identificador() + " apagado");
    }

    public static boolean estaEncdendido(Enchufable enchufable){
        return enchufable.estaEncendido();
    }
}

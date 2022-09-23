package com.dmeritano.patrones.comportamiento.observer;

public class Main {

    //Patron Observer - Uno habla == Muchos escuchan

    public static void main(String[] args) {

        Emisora emisora = new Emisora();
        ReceptorTV tv = new ReceptorTV();
        ReceptorRadio radio = new ReceptorRadio();
        ReceptorSatelite satelite = new ReceptorSatelite();

        emisora.agregarReceptor(tv);
        emisora.agregarReceptor(radio);
        emisora.agregarReceptor(satelite);

        emisora.emite();

    }
}

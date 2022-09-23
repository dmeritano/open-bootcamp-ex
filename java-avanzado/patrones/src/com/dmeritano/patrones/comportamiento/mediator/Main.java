package com.dmeritano.patrones.comportamiento.mediator;

public class Main {

    //Mediator - Actua de mediador entre dos o mas objetos
    //  El objecto que emite no recibe

    public static void main(String[] args) {
        //Un ejemplo usando clases abstractas en vez de interfaces
        //  para variar un poco, nada mas.

        Mediator mediator = new MediadorConcreto();
        Colega colega1 = new ColegaConcreto1();
        Colega colega2 = new ColegaConcreto2();

        mediator.registra(colega1);
        mediator.registra(colega2);

        colega1.envia();

        System.out.println("\n-------\n");

        Colega colega3 = new ColegaConcreto3();
        mediator.registra(colega3);
        colega1.envia();

        System.out.println("\n-------\n");

        colega2.envia();

        System.out.println("\n-------\n");

        colega3.envia();

    }
}

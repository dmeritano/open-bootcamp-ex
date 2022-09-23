package com.dmeritano.patrones.comportamiento.mediator;

public class ColegaConcreto2 extends Colega{

    @Override
    void recibe() {
        System.out.println("He recibido un mensaje, soy ColegaConcreto 2");
    }

    @Override
    void envia() {
        System.out.println("Soy ColegaConcreto 2 y envio un mensaje");
        mediator.reenvia(this);
    }
}


package com.dmeritano.patrones.comportamiento.mediator;

public class ColegaConcreto1 extends Colega{

    @Override
    void recibe() {
        System.out.println("He recibido un mensaje, soy ColegaConcreto 1");
    }

    @Override
    void envia() {
        System.out.println("Soy ColegaConcreto 1 y envio un mensaje");
        mediator.reenvia(this);
    }
}

package com.dmeritano.patrones.comportamiento.mediator;

public class ColegaConcreto3 extends Colega{

    @Override
    void recibe() {
        System.out.println("He recibido un mensaje, soy ColegaConcreto 3");
    }

    @Override
    void envia() {
        System.out.println("Soy ColegaConcreto 3 y envio un mensaje");
        mediator.reenvia(this);
    }
}
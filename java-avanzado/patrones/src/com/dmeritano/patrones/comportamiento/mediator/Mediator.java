package com.dmeritano.patrones.comportamiento.mediator;

public abstract class Mediator {

    abstract void registra(Colega colega);
    abstract void reenvia(Colega colega);
}

package com.dmeritano.patrones.comportamiento.observer;

public class ReceptorTV implements Receptor{

    @Override
    public void recibe() {
        System.out.println("Señal recibida en TV");
    }

}
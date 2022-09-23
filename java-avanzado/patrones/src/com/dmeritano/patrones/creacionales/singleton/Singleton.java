package com.dmeritano.patrones.creacionales.singleton;

public class Singleton {

    private static Singleton singleton;
    private int contador;

    public static Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    private Singleton(){}


    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}

package com.dmeritano.patrones.creacionales.factory;

public class PrecioFactory {

    private IPrecio precio;

    public PrecioFactory(String pais){
        if (pais.equalsIgnoreCase("españa")) {
            System.out.println("España - Euros");
            this.precio = new PrecioEuros();
        }
        else{
            System.out.println("Otro pais - USD");
            this.precio = new PrecioUsd();
        }
    }

    public double getPrecio(){
        return this.precio.getPrecio();
    }

    private PrecioFactory(){}
}

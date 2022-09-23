package com.dmeritano.patrones.creacionales.factory;

public class Main {

    public static void main(String[] args) {

        PrecioFactory precioFactory = new PrecioFactory("Canada");

        System.out.println(precioFactory.getPrecio());

        PrecioFactory precioFactory2 = new PrecioFactory("España");

        System.out.println(precioFactory2.getPrecio());

    }
}

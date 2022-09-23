package com.dmeritano.patrones.creacionales.prototype;

public class Moto implements Cloneable {

    public String marca;
    public String model;

    public Moto() {
    }

    public Moto clonar() throws CloneNotSupportedException {
        return (Moto) this.clone();
    }

    @Override
    public String toString() {
        return "Moto{" +
                "marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

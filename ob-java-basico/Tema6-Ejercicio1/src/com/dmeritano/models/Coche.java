package com.dmeritano.models;

public class Coche {

    private int id;
    private String marca;
    private String modelo;
    private int numPuertas;
    private int numRuedas;

    public Coche() {

    }

    public Coche(int id, String marca, String modelo, int numPuertas, int numRuedas) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.numPuertas = numPuertas;
        this.numRuedas = numRuedas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numPuertas=" + numPuertas +
                ", numRuedas=" + numRuedas +
                '}';
    }
}

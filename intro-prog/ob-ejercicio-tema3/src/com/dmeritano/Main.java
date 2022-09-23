package com.dmeritano;

public class Main {

    public static void main(String[] args) {

        int resultado = suma(3,5,6);
        System.out.println("Resultado suma: " + resultado);

        Coche coche = new Coche();
        coche.agregarPuertas();
        System.out.println("Numero de puertas del coche: " + coche.numPuertas);

    }

    private static int suma(int a, int b, int c){
        return a + b + c;
    }
}

class Coche {

    public int numPuertas = 0;

    public void agregarPuertas(){
        this.numPuertas++;
    }
}

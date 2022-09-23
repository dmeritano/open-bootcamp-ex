package com.dmeritano;

public class Main {

    private static final int COEFICIENTE_IVA = 20;

    public static void main(String[] args) {

        double precioProducto = 1050.30;
        double precioProductoConIva = precioConIVA(precioProducto);

        String output = String.format("Precio base: %.2f -  Precio con IVA(%d%%): %.2f ",
                precioProducto, COEFICIENTE_IVA, precioProductoConIva);

        System.out.println(output);
        /* Sample output

            Precio base: 1050,30 -  Precio con IVA(20%): 1260,36

        */

    }

    private static double precioConIVA(double precio){
        return precio + (precio * COEFICIENTE_IVA / 100);
    }
}

package com.dmeritano;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Suma iterativa  :" + suma(5));
        System.out.println("Suma recursiva  :" + sumaRecursiva(5));
        System.out.println("Suma funcional  :" + sumaFuncional(5));

        System.out.println("Factorial iterativo:  " + factorial(6));
        System.out.println("Factorial recursivo:  " + factorialRecursivo(6));
        System.out.println("Factorial funcional:  " + factorialFuncional(6));
    }

    private static int factorial(int numero){
        int resultado = 1;
        for (int i=1; i <= numero; i++){
            resultado = resultado * i;
        }
        return resultado;
    }

    private static int factorialRecursivo(int numero){
        if (numero == 0)
            return 1;
        return numero * factorialRecursivo(numero - 1);
    }

    private static int factorialFuncional(int numero){
        return IntStream.rangeClosed(1, numero).reduce(1, (a,b) -> a * b);
    }


    //Suma iterativa
    private static int suma(int numero){
        int resultado = 0;
        for (int i = 0; i <= numero ; i++) {
            resultado = resultado + i;
        }
        return resultado;
    }
    //Suma recursiva
    private static int sumaRecursiva(int numero) {
        if (numero == 1)
            return 1;
        return numero + sumaRecursiva(numero - 1);
    }
    //Suma funcional
    private static int sumaFuncional(int numero){
        return IntStream.rangeClosed(1, numero).reduce(0, (a,b) -> a+b);
    }
}




/*
   Funciones puras
   =============================================================================================================
    Es una funcion que llamada N veces con los mismos parametros devuelve el mismo resultado
    Es una funcion sin efectos colaterales: que no modifica variables/datos fuera de su ambito,
    ni llama a funciones impuras
    Debe hacer exactamente lo que dice. Si se llama suma debe sumar .. no restar ni sumar y restar ...

   Funciones de alto orden
   =============================================================================================================
    Una funcion puede llamar a otra funcion y recibir como respuesta una funcion

 */


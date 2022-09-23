package com.dmeritano;

public class Main {

    public static void main(String[] args) {

        int numeroIf = 10;

        if (numeroIf > 0){
            System.out.println("El numero es POSITIVO");
        }else if (numeroIf < 0 ){
            System.out.println("El numero es NEGATIVO");
        }else{
            System.out.println("El numero es cero (0)");
        }

        int numeroWhile = 1;
        while (numeroWhile < 3){
            numeroWhile = numeroWhile + 1;
            System.out.println(numeroWhile);
        }

        //numeroWhile => 3
        do {
            System.out.println(numeroWhile);
        } while(numeroWhile < 3);

        int numeroFor = 0;
        for (;numeroFor <= 3; numeroFor++){
            System.out.println(numeroFor);
        }

        String estacion = "VERANO";
        switch (estacion){
            case "VERANO":
                System.out.println("Es " + estacion);
                break;
            case "OTOÑO":
                System.out.println("Es " + estacion);
                break;
            case "INVIERNO":
                System.out.println("Es " + estacion);
                break;
            case "PRIMAVERA":
                System.out.println("Es " + estacion);
                break;
            default:
                System.out.println(estacion + " no es una estacion valida");
        }
    }
}

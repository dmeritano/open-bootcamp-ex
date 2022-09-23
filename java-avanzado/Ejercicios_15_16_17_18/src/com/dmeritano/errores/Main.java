package com.dmeritano.errores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args){

        int[] array = {1,3,4,6,8,9};

        try{

            int resultado = divideByZero(5, 2);
            System.out.println("Resultado division: " + resultado);

            int producto = array[4] * 3;
            System.out.println("Resultado producto: " + producto);

            ArrayList<String> listaResultados =
                    obtenerUltimosResultados("resultados.txt");

            System.out.println("Resultados previos: " + listaResultados.size());

        }catch (ArithmeticException | ArrayIndexOutOfBoundsException | IOException e){
            if (e.getClass().getName().contains("ArrayIndexOutOfBoundsException")){
                System.out.println("El indice del array no existe: " + e.getMessage());
            }else{
                System.out.println("Error " + e.getMessage());
            }
        }
    }


    private static int divideByZero(int a, int b) throws ArithmeticException{

        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw e;
        }

    }

    private static ArrayList<String> obtenerUltimosResultados(String archivo) throws IOException {

        ArrayList<String> ultimosResultados = new ArrayList();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(archivo));
            String linea = reader.readLine();
            while(linea != null){
                ultimosResultados.add(linea);
            }
            reader.close();
        } catch (IOException e) {
            throw e;
        }
        return ultimosResultados;
    }
}

package com.dmeritano;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        //Reversar cadena
        String msg = "hola mundo";
        System.out.println(reverse(msg, true));  // Con StringBuilder
        System.out.println(reverse(msg, false)); // Con un for loop tradicional

        //Array de strings
        String[] planetas = {"Mercurio", "Venus", "Tierra", "Marte", "Jupiter", "Saturno", "Urano", "Nepturno"};
        for (String planeta : planetas){
            System.out.println(planeta);
        }

        //Array bidimensional
        int[][] bidiArray = { {1, 10}, {2, 20}, {3, 30},{4, 40},{5, 50},{6, 60},{7, 70},{8, 80} };
        for (int i = 0; i < bidiArray.length; i++)
            for (int j = 0; j < bidiArray[i].length; j++)
                System.out.println("bidiArray[" + i + "][" + j + "] = " + bidiArray[i][j]);

        //Vectores
        Vector<String> vector = new Vector();
        vector.add("Lunes");
        vector.add("Martes");
        vector.add("Miercoles");
        vector.add("Jueves");
        vector.add("Viernes");
        vector.remove(1);       // Segundo elemento -> Martes
        vector.remove(2);       // Tercer  elemento -> Jueves (no es Miercoles, debido a la eliminacion anterior)
        System.out.println(vector);   // [Lunes, Miercoles, Viernes]

        /*
          Q: Cuál es el problema de utilizar un Vector con la capacidad por defecto si tuviésemos 1000 elementos para ser
             añadidos al mismo?

          A: Cada vez que se desborde la capacidad inicial por defecto (10), ésta irá incrementándose de a 10 elementos
             cada vez y esto, a nivel uso de la memmoria, repercute negativamente por las sucesivas copias que se irán
             haciendo del vector para su redimensionamiento.
         */


         //ArrayList y LinkedList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Athos");
        arrayList.add("Porthos");
        arrayList.add("Aramis");
        arrayList.add("D'Artagnan");

        LinkedList<String> linkedList = new LinkedList<>();

        //Copiar ArrayList en LinkedList (metodo nativo)
        for (String s : arrayList)
            linkedList.add(s);

        //Copiar ArrayList en LinkedList (usando api Stream)
        linkedList = arrayList.stream()
                .collect(Collectors.toCollection(LinkedList::new));

        //Mostrar resultados de ambas listas
        arrayList.forEach(System.out::println);
        linkedList.forEach(System.out::println);


        //ArrayList - Pares del 1 al 10
        ArrayList<Integer> enteros = new ArrayList<>();
        for (int i=1; i<=10; i++){
            if (i % 2 == 0)
                enteros.add(i);
        }
        System.out.println(enteros); //[1, 3, 5, 7, 9]

        //Excepciones -  Division por cero
        try {
            int division = DividePorCero(50, 0);
        }catch (ArithmeticException e){
            System.out.println("Esto no puede hacerse");
        }finally {
            System.out.println("Demo de codigo");
        }

        //Trabajando con archivos - Copia
        String fileIn = "text-file-source.txt";
        String fileOut = "text-file-source-copy.txt";
        copiarArchivos(fileIn, fileOut);

        //Sorprendenos ...
        //  Se genera un proceso sorprendente en una clase a parte (Utils)
        //  La descripción del proceso se documenta en dicha clase
        fileOut = "recuento-palabras.txt";
        try {
            Utils.procesoCuentaPalabras(fileIn,fileOut);
        } catch(IOException e){
            System.out.println("Error de entrada/salida procesando archivos: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Error general en el proceso sorprendente: " + e.getMessage());
        }
    }

    //Private functions
    private static void copiarArchivos(String fileIn, String fileOut) {

        InputStream entrada = null;
        BufferedInputStream bufferedInputStream = null;
        PrintStream salida = null;

        try {
            entrada = new FileInputStream(fileIn);
            bufferedInputStream = new BufferedInputStream(entrada);
            salida = new PrintStream(new FileOutputStream(fileOut));

            int buffer = bufferedInputStream.read();
            while (buffer != -1){
                salida.write(buffer);
                buffer = bufferedInputStream.read();
            }

            System.out.println("Archivo " + fileIn + " copiado en " + fileOut);

        }catch (IOException e){
            System.out.println(e.getClass().getName() + " - " + e.getMessage());
        }catch (Exception e){
            System.out.println(e.getClass().getName() + " - " + e.getMessage());
        }finally {
            if (entrada != null){ try {entrada.close();}catch (IOException e){}}
            if (bufferedInputStream != null){ try {bufferedInputStream.close();}catch (Exception e){}}
            if (salida != null){ try {salida.close();}catch (Exception e){}}
        }

    }


    private static int DividePorCero(int a, int b) throws ArithmeticException{
        int resultado = 0;
        try {
            resultado = a / b;
        }catch (ArithmeticException ex){
            throw new ArithmeticException();
        }
        return resultado;
    }

    private static String reverse(String texto, boolean useStringBuilder){
        if (useStringBuilder){
            StringBuilder sb = new StringBuilder(texto);
            return sb.reverse().toString();
        }else{
            char[] charArray = texto.toCharArray();
            String reversed = "";
            for (int x = charArray.length - 1; x >= 0; x--){
                reversed += charArray[x];
            }
            return reversed;
        }
    }
}

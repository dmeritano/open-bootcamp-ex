package com.dmeritano;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import static java.util.Collections.reverseOrder;

public class Utils {

    /**
        Este metodo lee un archivo de Texto y:

            - Obtiene cada una de las palabras que contiene

            - A las palabras les quita los signos de puntaucion que pueda tener, como "," ";" "-" "!" y
              caracteres especiales a partir de una lista.

            - Si la longitud resultante de la palabras se encuentra entre LONGITUD_MINIMA y LONGITUD_MAXIMA
              se la agrega laArrayList

            - Luego, se recorre el ArrayList obtenido y se genera un HashMap del tipo <String, Integer>,
              donde la idea es tener solo palabras únicas, y asociadas a estas la cantidad de veces
              que se repitieron en todo el texto.

            - Posteriormente, se generan un nuevo HashMap con las palabras ordenadas desde la que mas se
              reptitió a la que menos lo hizo.

            - Por último, se recorre el últimoa HashMap generado y se lo muestra por consola en formato
              palabra=cantidad , y los mismo se escribe en un archivo de salida (fileOut).
    **/
    public static void procesoCuentaPalabras(String fileIn, String fileOut) throws IOException, Exception {

        final int LONGITUD_MINIMA = 4;
        final int LONGITUD_MAXIMA = 15;

        try {

            InputStream entrada = new FileInputStream(fileIn);
            byte[] contenido = entrada.readAllBytes();
            entrada.close();

            String texto = new String(contenido);
            String[] arrayPalabras = texto.split(" ");

            ArrayList<String> listaPalabras = new ArrayList<>();
            for (String palabra : arrayPalabras){
                palabra = removerSignosPuntuacionEspeciales(palabra);
                listaPalabras.add(palabra.toLowerCase());
            }

            HashMap<String, Integer> mapaPalabras = new HashMap<>();
            for(String palabra : listaPalabras){
                if (palabra.length() >= LONGITUD_MINIMA && palabra.length() <= LONGITUD_MAXIMA)
                    mapaPalabras.put(palabra, mapaPalabras.getOrDefault(palabra, 0) + 1);
            }

            //Generamos un nuevo HashMap ordenado por value, descendente, de forma de tener al principio
            //  las palabras que mas se repitieron.
            HashMap<String, Integer> mapaPalabrasOrdenado = mapaPalabras.entrySet()
                    .stream()
                    .sorted(reverseOrder(Map.Entry.comparingByValue()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new)); //LinkedHashMap para garantizar orden

            //Finalmente, mostramos el mapa ordenado por pantalla y guardamos sus entradas en un archivo (fileOut)
            PrintStream salida = new PrintStream(new FileOutputStream(fileOut));
            for (Map.Entry entry : mapaPalabrasOrdenado.entrySet()){
                String temp = entry.getKey() + "=" + entry.getValue();
                System.out.println(temp);
                temp += "\n";
                salida.write(temp.getBytes(StandardCharsets.UTF_8));
            }
            salida.close();

        } catch (IOException e){
            throw e;
        }catch (Exception e){
            throw e;
        }

    }

    private static String removerSignosPuntuacionEspeciales(String palabra){
        String[] caracteres = {".", "," , ",", ";" ,"-","_","?","¿","¡","!","(",")","[","]","{","}",":", "\"", "\n", "\r"};
        String resp = palabra;
        for (String c : caracteres){
            if (resp.length() >= 1){
                resp = resp.replace(c,"");
            }
        }
        return resp;
    }

}

package strategy;

import org.reflections.Reflections;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("\nInicio del programa\n");

        //Usamos reflection para obtener dinamicamente las estrategias de ordenamiento
        ArrayList<Class> sortStrategies = getSortStragies();

        //Generamos un array de enteros, con cantidad de elementos random, al igual que sus valores
        int[] sourceArray = generateRandomIntegerArray();

        //Aplicamos las diferentes estrategias de ordenamiento para el array origen (sourceArray)
        for (Class strategy : sortStrategies){
            int[] targetArray = Arrays.copyOf(sourceArray, sourceArray.length);
            sort(strategy, targetArray);
        }

        System.out.println("\nFin del programa");
    }

    /* Sample output
        Inicio del programa

        Bubble Sort Algorithm, tiempo para ordenar 32103 numeros: 3515ms.
        Insertion Sort Algorithm, tiempo para ordenar 32103 numeros: 345ms.
        Selection Sort Algorithm, tiempo para ordenar 32103 numeros: 796ms.

        Fin del programa
     */


    //Private methods

    /**
     * Obtiene todas las clases que implementan la interface SortStrategy y devuelve:
     * @return ArrayList<Class>
     */
    private static ArrayList<Class> getSortStragies() {

        ArrayList<Class> strategyClasses = new ArrayList<>();
        try{
            Reflections reflections = new Reflections("");
            Set<Class<? extends SortStrategy>> classes = reflections.getSubTypesOf(SortStrategy.class);
            for (Class discoveredClass : classes){
                strategyClasses.add(discoveredClass);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return strategyClasses;

    }

    /**
     * Generan un array con una cantidad random de posiciones y completa cada una de estas posiciones
     * con numeros enteros aleatorios.
     * @return int[]
     */
    private static int[] generateRandomIntegerArray() {

        Random random = new Random();
        //Cantidad de elementos aleatoria
        int min = 10000;
        int max = 40000;
        int numberOfElements = random.nextInt(max + 1) + min;
        int[] array = new int[numberOfElements];

        //Llenamos el array, tambien con valores enteros aleatorios
        min = 1;
        max = 50000;
        for (int i=0; i < array.length; i++){
            array[i] = random.nextInt(max + 1) + min;
        }
        return array;
    }

    /**
     * Invoca los metodos definidios en la interfaz SortStrategy para la clase
     * recibida como parametros, junto al array a ordenar
     * @param sortStrategy Clase que implementa una estrategia de ordenamiento de un array
     * @param array Un array de enteros a ordenar
     */
    private static void sort(Class sortStrategy, int[] array){
        try {
            //Creamos instancia de la clase y definimos obtenemos los metodos que vamos a usar
            Object object = sortStrategy.getDeclaredConstructor().newInstance();
            Method methodRun = sortStrategy.getMethod("sort", int[].class);
            Method methodGetSortAlgorithmName = sortStrategy.getMethod("getSortAlgorithmName", null);
            Method methodGetSortTimeMs = sortStrategy.getMethod("getSortTimeMs", null);

            //Invocamos los metodos
            methodRun.invoke(object, array);
            long processTime = (long)methodGetSortTimeMs.invoke(object);
            String algorithmApplied = (String)methodGetSortAlgorithmName.invoke(object);

            //Mostramos los datos
            String out = String.format("%s, tiempo para ordenar %d numeros: %dms.",algorithmApplied, array.length, processTime);
            System.out.println(out);

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}

package strategy;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

    /**
     * Ejercicio 12-13-14
     *
     * Se utiliza ejercicio anterior (Ejercicios-9-10-11) para aplicar tecnicas de funcions limpias
     * y documentacion.
     *
     * Este programa es un ejemplo de implementacion del patron de comportamiento Strategy
     * en el cual a partir de una interface se crean diferentes estrategias para ordenar
     * un array de numeros enteros y para obtener el tiempo de ordenamiento para cada caso
     *
     * Las clase que implemetan la interfaz se descubren dinamicamente usando reflection.
     */
    public static void main(String[] args) {

        ArrayList<Class> sortStrategies = getSortStrategies();
        int[] sourceArray = generateRandomIntegerArray();
        for (Class strategy : sortStrategies){
            int[] targetArray = Arrays.copyOf(sourceArray, sourceArray.length);
            String result = null;
            try {
                result = sort(strategy, targetArray);
            } catch (NoSuchMethodException | InvocationTargetException |
                    IllegalAccessException | InstantiationException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(result);
        }
    }

    /**
     * A traves de Reflection se obtienen todas las clases que implementan la interface SortStrategy
     * @return ArrayList<Class> Una lista con las clases encontradas
     */
    private static ArrayList<Class> getSortStrategies() {
        ArrayList<Class> strategyClasses = new ArrayList<>();
        Reflections reflections = new Reflections("");
        Set<Class<? extends SortStrategy>> classes = reflections.getSubTypesOf(SortStrategy.class);
        for (Class discoveredClass : classes){
            strategyClasses.add(discoveredClass);
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
        //Definimos array con cantidad aleatoria de elementos
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
     * recibida como parametro
     * @param sortStrategy Clase que implementa una estrategia de ordenamiento de un array
     * @param array Un array de enteros a ordenar
     */
    private static String sort(Class sortStrategy, int[] array) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException, InstantiationException {
        //Creamos instancia de la clase y definimos obtenemos los metodos que vamos a usar
        Object object = sortStrategy.getDeclaredConstructor().newInstance();
        Method methodRun = sortStrategy.getMethod("sort", int[].class);
        Method methodGetSortAlgorithmName = sortStrategy.getMethod("getSortAlgorithmName", null);
        Method methodGetSortTimeMs = sortStrategy.getMethod("getSortTimeMs", null);

        //Invocamos los metodos
        methodRun.invoke(object, array);
        long processTime = (long)methodGetSortTimeMs.invoke(object);
        String algorithmApplied = (String)methodGetSortAlgorithmName.invoke(object);

        String result = String.format("%s, tiempo para ordenar %d numeros: %dms.",algorithmApplied, array.length,
                processTime);
        return result;
    }
}

package strategy;

/**
 * Interfaz para definir los metodos necesarios que deberan implementar las
 * clases que definan las diferentes estrategias de ordenamiento para un array de enteros
 */
public interface SortStrategy {

    String getSortAlgorithmName();
    void sort(int[] values);
    long getSortTimeMs();

}

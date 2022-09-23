package strategy;

public interface SortStrategy {

    String getSortAlgorithmName();
    void sort(int[] values);
    long getSortTimeMs();

}

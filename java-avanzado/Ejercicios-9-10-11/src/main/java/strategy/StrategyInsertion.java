package strategy;

import java.util.Random;

public class StrategyInsertion implements SortStrategy{

    private long sortTime = 0;

    @Override
    public String getSortAlgorithmName() {
        return "Insertion Sort Algorithm";
    }

    @Override
    public void sort(int[] values) {
        long msStart = System.currentTimeMillis();
        customSortAlgorithm(values);
        sortTime = System.currentTimeMillis() - msStart;
    }

    @Override
    public long getSortTimeMs() {
        return sortTime;
    }

    private void customSortAlgorithm(int[] values){
        for (int i = 1; i < values.length; i++) {
            int key = values[i];
            int j = i - 1;
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j = j - 1;
            }
            values[j + 1] = key;
        }
    }
}

package strategy;

import java.util.Random;

public class StrategySelection implements SortStrategy{

    private long sortTime = 0;

    @Override
    public String getSortAlgorithmName() {
        return "Selection Sort Algorithm";
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

        for (int i = 0; i < values.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[minElementIndex] > values[j]) {
                    minElementIndex = j;
                }
            }

            if (minElementIndex != i) {
                int temp = values[i];
                values[i] = values[minElementIndex];
                values[minElementIndex] = temp;
            }
        }

    }
}

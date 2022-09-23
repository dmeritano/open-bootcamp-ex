package strategy;

import java.util.Random;
import java.util.stream.IntStream;

public class StrategyBubble implements SortStrategy{

    private long sortTime = 0;

    @Override
    public String getSortAlgorithmName() {
        return "Bubble Sort Algorithm";
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
        int n = values.length;
        IntStream.range(0, n - 1)
                .flatMap(i -> IntStream.range(1, n - i))
                .forEach(j -> {
                    if (values[j - 1] > values[j]) {
                        int temp = values[j];
                        values[j] = values[j - 1];
                        values[j - 1] = temp;
                    }
                });
    }
}

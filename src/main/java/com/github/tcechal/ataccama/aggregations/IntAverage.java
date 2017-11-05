package com.github.tcechal.ataccama.aggregations;

public class IntAverage {

    public static double calculate(int[] numbers) {

        int count = 0;
        long sum = 0L;

        for (int number: numbers) {
            count++;
            sum += number;
        }

        return sum / (double) count;
    }
}

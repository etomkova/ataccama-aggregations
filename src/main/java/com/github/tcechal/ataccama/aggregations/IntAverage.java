package com.github.tcechal.ataccama.aggregations;

public class IntAverage {

    public static void calculate(int[] numbers) {

        int count = 0;
        long sum = 0L;

        for (int number: numbers) {
            count++;
            sum += number;
        }

        System.out.println(sum / (double) count);
    }
}

package com.github.tcechal.ataccama.aggregations.impl;

import com.github.tcechal.ataccama.aggregations.Aggregator;

public class IntAverage implements Aggregator<Integer, Double> {

    public Double aggregate(Integer[] numbers) {

        int count = 0;
        long sum = 0L;

        for (int number: numbers) {
            count++;
            sum += number;
        }

        return sum / (double) count;
    }
}

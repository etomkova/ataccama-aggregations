package com.github.tcechal.ataccama.aggregations.impl;

import com.github.tcechal.ataccama.aggregations.IntAggregator;

public class IntAverage implements IntAggregator {

    public double aggregate(int[] numbers) {

        int count = 0;
        long sum = 0L;

        for (int number: numbers) {
            count++;
            sum += number;
        }

        return sum / (double) count;
    }
}

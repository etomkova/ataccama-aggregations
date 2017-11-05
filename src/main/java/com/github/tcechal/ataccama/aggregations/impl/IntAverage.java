package com.github.tcechal.ataccama.aggregations.impl;

import com.github.tcechal.ataccama.aggregations.Aggregator;
import com.github.tcechal.ataccama.sources.Source;


public class IntAverage implements Aggregator<Integer, Double> {

    public Double aggregate(Source<Integer> numbers) {

        int count = 0;
        long sum = 0L;

        for (int number: numbers) {
            count++;
            sum += number;
        }

        return sum / (double) count;
    }
}

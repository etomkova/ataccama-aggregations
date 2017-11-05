package com.github.tcechal.ataccama.aggregations;

import com.github.tcechal.ataccama.AggregateFn;
import com.github.tcechal.ataccama.Source;


public class IntAverage implements AggregateFn<Integer, Double> {

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

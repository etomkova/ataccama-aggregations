package com.github.tcechal.ataccama.aggregations;

import com.github.tcechal.ataccama.aggregations.impl.IntAverage;

public class Driver {

    public static void main(String[] args) {

        Integer[] numbers = {1, 2, 3, 4, 5};

        Aggregator<Integer, Double> aggregator = new IntAverage();

        System.out.println(aggregator.aggregate(numbers));
    }
}

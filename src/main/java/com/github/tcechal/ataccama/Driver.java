package com.github.tcechal.ataccama;

import com.github.tcechal.ataccama.aggregations.Aggregator;
import com.github.tcechal.ataccama.aggregations.impl.IntAverage;
import com.github.tcechal.ataccama.sources.Source;
import com.github.tcechal.ataccama.sources.Sources;

public class Driver {

    public static void main(String[] args) {

        Integer[] numbers = {1, 2, 3, 4, 5};

        Source<Integer> source = Sources.fromArray(numbers);
        Aggregator<Integer, Double> aggregator = new IntAverage();

        System.out.println(aggregator.aggregate(source));
    }
}

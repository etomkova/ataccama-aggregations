package com.github.tcechal.ataccama;

import com.github.tcechal.ataccama.aggregations.IntAverage;
import com.github.tcechal.ataccama.dataset.MemoryDataSet;
import com.github.tcechal.ataccama.transformations.PositiveInts;


public class Driver {

    public static void main(String[] args) {

        Integer[] numbers = {-2, -1, 0, 0, 1, 2};

        Double result = MemoryDataSet
                .create(From.array(numbers))
                .transform(new PositiveInts())
                .aggregate(new IntAverage());

        System.out.println(result);
    }
}

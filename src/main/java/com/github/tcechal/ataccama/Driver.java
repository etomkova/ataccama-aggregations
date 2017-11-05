package com.github.tcechal.ataccama;

import com.github.tcechal.ataccama.aggregations.IntAverage;
import com.github.tcechal.ataccama.dataset.MemoryDataSet;

public class Driver {

    public static void main(String[] args) {

        Integer[] numbers = {1, 2, 3, 4, 5};

        Source<Integer> source = Sources.fromArray(numbers);
        DataSet<Integer> ints = new MemoryDataSet<>(source);
        Double result = ints.aggregate(new IntAverage());

        System.out.println(result);
    }
}

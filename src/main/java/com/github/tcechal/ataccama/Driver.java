package com.github.tcechal.ataccama;

import com.github.tcechal.ataccama.dataset.MemoryDataSet;
import com.github.tcechal.ataccama.lib.Ints;
import com.github.tcechal.ataccama.sources.From;


public class Driver {

    public static void main(String[] args) {

        Integer[] numbers = {-2, -1, 0, 0, 1, 2};

        Double result = MemoryDataSet
                .create(From.array(numbers))
                .transform(Ints.abs())
                .aggregate(Ints.mean());

        System.out.println(result);
    }
}

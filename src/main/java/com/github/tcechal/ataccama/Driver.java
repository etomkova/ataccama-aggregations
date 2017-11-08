package com.github.tcechal.ataccama;

import com.github.tcechal.ataccama.aggregations.dataset.LazyDataSet;
import com.github.tcechal.ataccama.aggregations.lib.Ints;
import com.github.tcechal.ataccama.aggregations.source.From;


public class Driver {

    public static void main(String[] args) {

        System.out.println(LazyDataSet
                .create(From.array(new Integer[] {-2, -1, 0, 0, 1, 2}))
                .transform(Math::abs)
                .aggregate(Ints::mean));
    }
}

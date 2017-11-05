package com.github.tcechal.ataccama.aggregations;

public interface Aggregator<T, R> {

    R aggregate(T[] input);
}

package com.github.tcechal.ataccama;


public interface AggregateFn<T, R> {

    R aggregate(Source<T> input);
}

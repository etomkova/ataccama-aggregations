package com.github.tcechal.ataccama;


@FunctionalInterface
public interface AggregateFn<T, R> {

    R aggregate(Iterable<T> input);
}

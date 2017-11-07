package com.github.tcechal.ataccama.aggregations;


/**
 * Represents a general aggregation function producing a single result value from a collection of input values.
 * @param <T> Type of the input data items.
 * @param <R> Type of the output value.
 */
@FunctionalInterface
public interface AggregateFn<T, R> {

    /**
     * The aggregation operation itself.
     * @param input Input data items.
     * @return Result of the aggregation.
     */
    R aggregate(Iterable<T> input);
}

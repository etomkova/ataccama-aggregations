package com.github.tcechal.ataccama;

import java.util.function.Function;


public interface DataSet<T> extends Source<T> {

    <R> DataSet<R> transform(Function<T, R> transformFn);
    <R> R aggregate(AggregateFn<T, R> aggregateFn);
}

package com.github.tcechal.ataccama;


public interface DataSet<T> extends Iterable<T> {

    <R> DataSet<R> transform(TransformFn<T, R> transformFn);
    <R> R aggregate(AggregateFn<T, R> aggregateFn);
}

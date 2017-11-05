package com.github.tcechal.ataccama;


public interface DataSet<T> extends Source<T> {

    <R> DataSet<R> transform(TransformFn<T, R> transformFn);
    <R> R aggregate(AggregateFn<T, R> aggregateFn);
}

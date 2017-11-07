package com.github.tcechal.ataccama;


/**
 * Represents a simple function that takes a single argument and produces a single output value.
 * @param <T> Type of the input argument.
 * @param <R> Type of the output value.
 */
@FunctionalInterface
public interface TransformFn<T, R> {

    /**
     * The transform operation itsef.
     * @param item The object to be transformed.
     * @return Result of the transformation.
     */
    R transform(T item);
}

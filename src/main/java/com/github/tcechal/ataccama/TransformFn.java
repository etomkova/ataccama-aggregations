package com.github.tcechal.ataccama;

@FunctionalInterface
public interface TransformFn<T, R> {

    R transform(T item);
}

package com.github.tcechal.ataccama;

public interface TransformFn<T, R> {

    R transform(T item);
}

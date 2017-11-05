package com.github.tcechal.ataccama.transformations;

import com.github.tcechal.ataccama.TransformFn;


public class PositiveInts implements TransformFn<Integer, Integer> {

    @Override
    public Integer transform(Integer item) {

        return Math.abs(item);
    }
}

package com.github.tcechal.ataccama.sources;

import java.util.Arrays;


public final class From {

    public static <T> Iterable<T> array(T[] items) {

        return Arrays.asList(items);
    }

    public static <T> Iterable<T> iterable(Iterable<T> items) {

        return items;
    }
}

package com.github.tcechal.ataccama;

import java.util.Arrays;
import java.util.Collection;

import com.github.tcechal.ataccama.sources.CollectionSource;


public final class From {

    public static <T> Source<T> array(T[] items) {

        return new CollectionSource<>(Arrays.asList(items));
    }

    public static <T> Source<T> collection(Collection<T> items) {

        return new CollectionSource<>(items);
    }
}

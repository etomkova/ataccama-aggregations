package com.github.tcechal.ataccama;

import java.util.Arrays;
import java.util.Collection;

import com.github.tcechal.ataccama.Source;
import com.github.tcechal.ataccama.sources.CollectionSource;


public class Sources {

    public static <T> Source<T> fromArray(T[] items) {

        return new CollectionSource<>(Arrays.asList(items));
    }

    public static <T> Source<T> fromCollection(Collection<T> items) {

        return new CollectionSource<>(items);
    }
}

package com.github.tcechal.ataccama.aggregations.source;

import java.util.Arrays;

import com.github.tcechal.ataccama.aggregations.DataSet;


/**
 * Library of custom iterables that can be used to create {@link DataSet} instances.
 */
public final class From {

    private From() {}

    /**
     * Wrap an array into an iterable, to be used as {@link DataSet} source.
     */
    public static <T> Iterable<T> array(T[] items) {

        return Arrays.asList(items);
    }

    /**
     * No-op iterable wrapper.
     *
     * The only purpose of this method is to provide the same API for constructing
     * {@link DataSet}s from iterables with respect to other sources like arrays.
     */
    public static <T> Iterable<T> iterable(Iterable<T> items) {

        return items;
    }

    /**
     * Wrap a text textFile so that it can be viewed as iterable of its lines.
     * @param path Path to the textFile, on local textFile system.
     */
    public static Iterable<String> textFile(String path) {

        return new TextFileLines(path);
    }
}

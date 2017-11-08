package com.github.tcechal.ataccama.aggregations.lib;


/**
 * A collection of aggegation functions working on items of type {@link Integer}.
 */
public final class Ints {

    private Ints() {}

    /**
     * Calculate maximum of given items.
     */
    public static Integer max(Iterable<Integer> items) {

        Integer max = null;
        for (Integer item: items) {

            if (max == null) {
                max = item;
                continue;
            }

            if (item > max) {
                max = item;
            }
        }

        return max;
    }

    /**
     * Calculate mean of given items.
     *
     * A simple implementation that does not consider overflows.
     */
    public static Double mean(Iterable<Integer> items) {

        int count = 0;
        int sum = 0;

        for (Integer item: items) {
            count++;
            sum += item;
        }

        return sum / (double) count;
    }

    /**
     * Calculate sum of given items.
     *
     * A simple implementation that does not consider overflows.
     */
    public static Integer sum(Iterable<Integer> items) {

        int sum = 0;

        for (Integer item: items) {
            sum += item;
        }

        return sum;
    }
}

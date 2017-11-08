package com.github.tcechal.ataccama.aggregations.lib;


/**
 * A collection of aggegation functions working on items of type {@link Integer}.
 */
public final class Ints {

    private Ints() {}

    /**
     * Calculate maximum of given items.
     *
     * Returns null for empty input iterable.
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
     * Returns null for empty input iterable.
     */
    public static Double mean(Iterable<Integer> items) {

        int count = 0;
        int sum = 0;

        for (Integer item: items) {
            count++;
            sum += item;
        }

        if (count == 0) {
            return null;
        } else {
            return sum / (double) count;
        }
    }

    /**
     * Calculate sum of given items.
     *
     * A simple implementation that does not consider overflows.
     * Returns 0 for empty input iterable.
     */
    public static Integer sum(Iterable<Integer> items) {

        int sum = 0;

        for (Integer item: items) {
            sum += item;
        }

        return sum;
    }
}

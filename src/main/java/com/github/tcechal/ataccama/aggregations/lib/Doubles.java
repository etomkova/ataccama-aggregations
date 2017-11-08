package com.github.tcechal.ataccama.aggregations.lib;


/**
 * A collection of aggegation functions working on items of type {@link Double}.
 */
public final class Doubles {

    private Doubles() {}

    /**
     * Calculate maximum of given items.
     */
    public static Double max(Iterable<Double> items) {

        Double max = null;
        for (Double item: items) {

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
     * A simple implementation that does not consider overflows, rounding
     * errors or special values such as Inf or NaN.
     */
    public static Double mean(Iterable<Double> items) {

        int count = 0;
        double sum = 0.0;

        for (Double item: items) {
            count++;
            sum += item;
        }

        return sum / count;
    }

    /**
     * Calculate sum of given items.
     *
     * A simple implementation that does not consider overflows, rounding
     * errors or special values such as Inf or NaN.
     */
    public static Double sum(Iterable<Double> items) {

        double sum = 0.0;

        for (Double item: items) {
            sum += item;
        }

        return sum;
    }
}

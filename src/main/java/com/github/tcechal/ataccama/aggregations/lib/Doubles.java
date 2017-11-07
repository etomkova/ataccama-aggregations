package com.github.tcechal.ataccama.aggregations.lib;


public class Doubles {

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

    public static Double mean(Iterable<Double> items) {

        int count = 0;
        double sum = 0.0;

        for (Double item: items) {
            count++;
            sum += item;
        }

        return sum / count;
    }

    public static Double sum(Iterable<Double> items) {

        double sum = 0.0;

        for (Double item: items) {
            sum += item;
        }

        return sum;
    }
}

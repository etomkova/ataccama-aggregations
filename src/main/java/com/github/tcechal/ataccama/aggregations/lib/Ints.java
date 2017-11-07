package com.github.tcechal.ataccama.aggregations.lib;


public class Ints {

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

    public static Double mean(Iterable<Integer> items) {

        int count = 0;
        int sum = 0;

        for (Integer item: items) {
            count++;
            sum += item;
        }

        return sum / (double) count;
    }

    public static Integer sum(Iterable<Integer> items) {

        int sum = 0;

        for (Integer item: items) {
            sum += item;
        }

        return sum;
    }
}

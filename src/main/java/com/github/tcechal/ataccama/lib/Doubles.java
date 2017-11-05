package com.github.tcechal.ataccama.lib;

import com.github.tcechal.ataccama.AggregateFn;


public class Doubles {

    public static AggregateFn<Double, Double> max() {
        return new Max();
    }

    public static AggregateFn<Double, Double> mean() {
        return new Mean();
    }

    public static AggregateFn<Double, Double> sum() {
        return new Sum();
    }


    private static class Max implements AggregateFn<Double, Double> {

        @Override
        public Double aggregate(Iterable<Double> items) {

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
    }

    private static class Mean implements AggregateFn<Double, Double> {

        @Override
        public Double aggregate(Iterable<Double> items) {

            int count = 0;
            double sum = 0.0;

            for (Double item: items) {
                count++;
                sum += item;
            }

            return sum / count;
        }
    }

    private static class Sum implements AggregateFn<Double, Double> {

        @Override
        public Double aggregate(Iterable<Double> items) {

            double sum = 0.0;

            for (Double item: items) {
                sum += item;
            }

            return sum;
        }
    }
}

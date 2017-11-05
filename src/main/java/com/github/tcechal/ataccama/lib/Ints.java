package com.github.tcechal.ataccama.lib;

import com.github.tcechal.ataccama.AggregateFn;
import com.github.tcechal.ataccama.TransformFn;


public class Ints {

    public static TransformFn<Integer, Integer> abs() {
        return new Abs();
    }

    public static AggregateFn<Integer, Integer> max() {
        return new Max();
    }

    public static AggregateFn<Integer, Double> mean() {
        return new Mean();
    }

    public static AggregateFn<Integer, Integer> sum() {
        return new Sum();
    }


    private static class Abs implements TransformFn<Integer, Integer> {

        @Override
        public Integer transform(Integer item) {

            return Math.abs(item);
        }
    }

    private static class Max implements AggregateFn<Integer, Integer> {

        @Override
        public Integer aggregate(Iterable<Integer> items) {

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
    }

    private static class Mean implements AggregateFn<Integer, Double> {

        @Override
        public Double aggregate(Iterable<Integer> items) {

            int count = 0;
            int sum = 0;

            for (Integer item: items) {
                count++;
                sum += item;
            }

            return sum / (double) count;
        }
    }

    private static class Sum implements AggregateFn<Integer, Integer> {

        @Override
        public Integer aggregate(Iterable<Integer> items) {

            int sum = 0;

            for (Integer item: items) {
                sum += item;
            }

            return sum;
        }
    }
}

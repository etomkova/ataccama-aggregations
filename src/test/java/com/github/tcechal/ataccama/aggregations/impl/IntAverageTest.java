package com.github.tcechal.ataccama.aggregations.impl;

import com.github.tcechal.ataccama.AggregateFn;
import com.github.tcechal.ataccama.aggregations.IntAverage;
import com.github.tcechal.ataccama.Source;
import com.github.tcechal.ataccama.From;
import org.junit.Assert;
import org.junit.Test;

public class IntAverageTest {

    @Test
    public void calculate() throws Exception {

        Source<Integer> numbers = From.array(new Integer[] {1, 2, 3, 4, 5});
        AggregateFn<Integer, Double> aggregateFn = new IntAverage();

        Assert.assertEquals(3.0, aggregateFn.aggregate(numbers), 1.0E-6);
    }

}

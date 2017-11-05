package com.github.tcechal.ataccama.aggregations.impl;

import com.github.tcechal.ataccama.aggregations.IntAggregator;
import org.junit.Assert;
import org.junit.Test;

public class IntAverageTest {

    @Test
    public void calculate() throws Exception {

        int[] numbers = {1, 2, 3, 4, 5};

        IntAggregator aggregator = new IntAverage();

        Assert.assertEquals(3.0, aggregator.aggregate(numbers), 1.0E-6);
    }

}

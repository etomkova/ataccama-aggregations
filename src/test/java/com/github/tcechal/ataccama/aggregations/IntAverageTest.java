package com.github.tcechal.ataccama.aggregations;

import org.junit.Assert;
import org.junit.Test;

public class IntAverageTest {

    @Test
    public void calculate() throws Exception {

        int[] numbers = {1, 2, 3, 4, 5};

        Assert.assertEquals(3.0, IntAverage.calculate(numbers), 1.0E-6);
    }

}

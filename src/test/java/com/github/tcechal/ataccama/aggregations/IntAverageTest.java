package com.github.tcechal.ataccama.aggregations;

import org.junit.Test;

public class IntAverageTest {

    @Test
    public void calculate() throws Exception {

        int[] numbers = {1, 2, 3, 4, 5};

        IntAverage.calculate(numbers);
    }

}

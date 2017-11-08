package com.github.tcechal.ataccama.aggregations.lib;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


// no tests for overflows, underflows, Infs, NaNs etc.
public class DoublesTest {

    @Test
    public void simpleMax() throws Exception {

        List<Double> input = Arrays.asList(1.0, 0.0, -1.0);
        Assert.assertEquals(Double.valueOf(1.0), Doubles.max(input));
    }

    @Test
    public void emptyMax() throws Exception {

        List<Double> input = Collections.emptyList();
        Assert.assertNull(Doubles.max(input));
    }

    @Test
    public void simpleMean() throws Exception {

        List<Double> input = Arrays.asList(1.0, 0.0, -1.0);
        Assert.assertEquals(Double.valueOf(0.0), Doubles.mean(input));
    }

    @Test
    public void emptyMean() throws Exception {

        List<Double> input = Collections.emptyList();
        Assert.assertNull(Doubles.mean(input));
    }

    @Test
    public void simpleSum() throws Exception {

        List<Double> input = Arrays.asList(2.0, 0.0, -1.0);
        Assert.assertEquals(Double.valueOf(1.0), Doubles.sum(input));
    }

    @Test
    public void emptySum() throws Exception {

        List<Double> input = Collections.emptyList();
        Assert.assertEquals(Double.valueOf(0.0), Doubles.sum(input));
    }
}

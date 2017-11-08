package com.github.tcechal.ataccama.aggregations.lib;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


// no tests for overflows, underflows, etc.
public class IntsTest {

    @Test
    public void simpleMax() throws Exception {

        List<Integer> input = Arrays.asList(1, 0, -1);
        Assert.assertEquals(Integer.valueOf(1), Ints.max(input));
    }

    @Test
    public void emptyMax() throws Exception {

        List<Integer> input = Collections.emptyList();
        Assert.assertNull(Ints.max(input));
    }

    @Test
    public void simpleMean() throws Exception {

        List<Integer> input = Arrays.asList(1, 0, -1);
        Assert.assertEquals(Double.valueOf(0.0), Ints.mean(input));
    }

    @Test
    public void emptyMean() throws Exception {

        List<Integer> input = Collections.emptyList();
        Assert.assertNull(Ints.mean(input));
    }

    @Test
    public void simpleSum() throws Exception {

        List<Integer> input = Arrays.asList(1, 0, -1);
        Assert.assertEquals(Integer.valueOf(0), Ints.sum(input));
    }

    @Test
    public void emptySum() throws Exception {

        List<Integer> input = Collections.emptyList();
        Assert.assertEquals(Integer.valueOf(0), Ints.sum(input));
    }
}

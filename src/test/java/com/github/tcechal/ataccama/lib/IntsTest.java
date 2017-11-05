package com.github.tcechal.ataccama.lib;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class IntsTest {

    @Test
    public void abs() throws Exception {

        List<Integer> inputs = Arrays.asList(1, 0, -1);
        List<Integer> expected = Arrays.asList(1, 0, 1);

        for (int i = 0; i < inputs.size(); i++) {
            Assert.assertEquals(expected.get(i), Ints.abs().transform(inputs.get(i)));
        }
    }

    @Test
    public void max() throws Exception {

        List<Integer> input = Arrays.asList(1, 0, -1);
        Assert.assertEquals(Integer.valueOf(1), Ints.max().aggregate(input));
    }

    @Test
    public void mean() throws Exception {

        List<Integer> input = Arrays.asList(1, 0, -1);
        Assert.assertEquals(Double.valueOf(0.0), Ints.mean().aggregate(input));
    }

    @Test
    public void sum() throws Exception {

        List<Integer> input = Arrays.asList(1, 0, -1);
        Assert.assertEquals(Integer.valueOf(0), Ints.sum().aggregate(input));
    }
}

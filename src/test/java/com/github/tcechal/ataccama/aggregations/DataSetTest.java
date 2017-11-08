package com.github.tcechal.ataccama.aggregations;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.github.tcechal.ataccama.aggregations.dataset.LazyDataSet;
import com.github.tcechal.ataccama.aggregations.dataset.MemoryDataSet;
import com.github.tcechal.ataccama.aggregations.lib.Ints;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class DataSetTest {

    private final Class implementationClass;

    /**
     * A constructor supporting parametrized tests.
     */
    public DataSetTest(Class implementationClass) {

        this.implementationClass = implementationClass;
    }

    /**
     * Parameters for the parametrized test runner, a list of DataSet implementations to be tested.
     */
    @Parameterized.Parameters
    public static Collection<Object[]> implementations() {

        Object[][] data = {{ MemoryDataSet.class }, { LazyDataSet.class }};
        return Arrays.asList(data);
    }

    /**
     * Helper method that calls "create" on the supplied class implementing the DataSet interface.
     */
    @SuppressWarnings("unchecked")
    private <T> DataSet<T> createGeneric(Iterable<T> input) throws Exception {

        Method method = implementationClass.getMethod("create", Iterable.class);

        return (DataSet<T>) method.invoke(null, input);
    }

    @Test
    public void createFromIterable() throws Exception {

        final List<String> input = Arrays.asList("cat", "dog");
        final DataSet<String> dataset = createGeneric(input);

        Assert.assertEquals(input, dataset.collect());
    }

    @Test
    public void createFromEmptyIterable() throws Exception {

        final List<String> input = Collections.emptyList();
        final DataSet<String> dataset = createGeneric(input);

        Assert.assertEquals(input, dataset.collect());
    }

    @Test
    public void simpleTransformation() throws Exception {

        final List<String> input = Arrays.asList("1", "2");
        final List<Integer> output = Arrays.asList(1, 2);

        final DataSet<String> inputDataSet = createGeneric(input);
        final DataSet<Integer> outputDataSet = inputDataSet.transform(Integer::parseInt);

        Assert.assertEquals(output, outputDataSet.collect());
    }

    @Test
    public void emptyTransformation() throws Exception {

        final List<String> input = Collections.emptyList();
        final List<Integer> output = Collections.emptyList();

        final DataSet<String> inputDataSet = createGeneric(input);
        final DataSet<Integer> outputDataSet = inputDataSet.transform(Integer::parseInt);

        Assert.assertEquals(output, outputDataSet.collect());
    }

    @Test(expected = NumberFormatException.class)
    public void exceptionDuringTransformation() throws Exception {

        final List<String> input = Arrays.asList("1", "crash");

        final DataSet<String> inputDataSet = createGeneric(input);
        final DataSet<Integer> outputDataSet = inputDataSet.transform(Integer::parseInt);

        outputDataSet.collect();
    }

    @Test
    public void simpleAggregation() throws Exception {

        final List<Integer> input = Arrays.asList(1, 2);
        final DataSet<Integer> inputDataSet = createGeneric(input);

        Assert.assertEquals(Integer.valueOf(2), inputDataSet.count());
        Assert.assertEquals(Integer.valueOf(2), inputDataSet.aggregate(Ints::max));
    }

    @Test
    public void emptyAggregation() throws Exception {

        final List<Integer> input = Collections.emptyList();
        final DataSet<Integer> inputDataSet = createGeneric(input);

        Assert.assertNull(inputDataSet.aggregate(Ints::max));
    }

    @Test
    public void chainedTransformations() throws Exception {

        final List<Integer> input = Arrays.asList(1, 2);
        final DataSet<Integer> dataset = createGeneric(input)
                .transform(x -> x + 1)
                .transform(x -> x + 1);

        Assert.assertEquals(Arrays.asList(3, 4), dataset.collect());
    }

    @Test
    public void forkedTransformations() throws Exception {

        final List<Integer> input = Arrays.asList(1, 2);
        final DataSet<Integer> inputDataSet = createGeneric(input);
        final DataSet<Integer> left = inputDataSet.transform(x -> x + 1);
        final DataSet<Integer> right = inputDataSet.transform(x -> x - 1);

        Assert.assertEquals(Arrays.asList(2, 3), left.collect());
        Assert.assertEquals(Arrays.asList(0, 1), right.collect());
    }

    @Test
    public void transformAndAggregate() throws Exception {

        final List<String> input = Arrays.asList("1", "2");

        final Integer result = createGeneric(input)
                .transform(Integer::parseInt)
                .transform(x -> -x)
                .aggregate(Ints::max);

        Assert.assertEquals(Integer.valueOf(-1), result);
    }
}

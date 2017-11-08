package com.github.tcechal.ataccama.aggregations;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a collection of data items.
 *
 * The data can be either transformed, producing a DataSet of another type,
 * or aggregated, producing a single value as a result. A DataSet can also
 * be iterated.
 *
 * @param <T> The type of items stored in the DataSet.
 */
public interface DataSet<T> extends Iterable<T> {

    /**
     * Transform each item in this DataSet using the given function, producing a DataSet of the results.
     *
     * @param transformFn Function converting an item of the source DataSet into an item of the output DataSet.
     * @param <R> The type of the transformed items.
     * @return A new DataSet instance containing transformed items from the source DataSet.
     */
    <R> DataSet<R> transform(TransformFn<T, R> transformFn);

    /**
     * Perform an aggregation of all items in the dataset and produce a single result value.
     *
     * @param aggregateFn Aggregation function.
     * @param <R> Type of the result.
     * @return Result of the aggregation.
     */
    <R> R aggregate(AggregateFn<T, R> aggregateFn);

    /**
     * Return a list containing all items in this DataSet.
     */
    default List<T> collect() {

        List<T> collected = new ArrayList<>();
        iterator().forEachRemaining(collected::add);

        return collected;
    }

    /**
     * Return the total number of items in this DataSet.
     */
    default Integer count() {

        Iterator<T> it = iterator();

        Integer cnt = 0;
        while (it.hasNext()) {
            it.next();
            cnt++;
        }

        return cnt;
    }
}

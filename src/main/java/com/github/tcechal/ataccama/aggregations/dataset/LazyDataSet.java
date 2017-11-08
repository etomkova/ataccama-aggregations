package com.github.tcechal.ataccama.aggregations.dataset;

import java.util.Iterator;

import com.github.tcechal.ataccama.aggregations.AggregateFn;
import com.github.tcechal.ataccama.aggregations.DataSet;
import com.github.tcechal.ataccama.aggregations.TransformFn;


/**
 * A DataSet that is created only when its items are needed.
 *
 * Transformations produce a new DataSet that remembers the source iterable
 * and the operation needed to create its data from the source data. These
 * items are only materialized when necessary, i.e. when iterated over or when
 * an aggregate value needs to be calculated.
 */
public final class LazyDataSet<T, R> implements DataSet<T> {

    // Custom iterator that wraps the source iterator.
    private static final class TransformIterator<S, U> implements Iterator<S> {

        private final Iterator<U> source;
        private final TransformFn<U, S> transformer;


        private TransformIterator(Iterator<U> source, TransformFn<U, S> transformer) {

            this.source = source;
            this.transformer = transformer;
        }

        @Override
        public boolean hasNext() {

            return source.hasNext();
        }

        @Override
        public S next() {

            return transformer.transform(source.next());
        }
    }


    private final Iterable<R> source;
    private final TransformFn<R, T> transformer;

    /**
     * Creates a new DataSet from given source iterable.
     * @param source An iterable capable of producing data items.
     * @return New DataSet representing data from the source.
     */
    public static <T> DataSet<T> create(Iterable<T> source) {

        return new LazyDataSet<>(source, x -> x);
    }

    private LazyDataSet(Iterable<R> source, TransformFn<R, T> transformer) {

        this.source = source;
        this.transformer = transformer;
    }

    @Override
    public <S> DataSet<S> transform(TransformFn<T, S> transformFn) {

        return new LazyDataSet<>(this, transformFn);
    }

    @Override
    public <S> S aggregate(AggregateFn<T, S> aggregateFn) {

        return aggregateFn.aggregate(this);
    }

    @Override
    public Iterator<T> iterator() {

        return new TransformIterator<>(source.iterator(), transformer);
    }
}

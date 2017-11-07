package com.github.tcechal.ataccama.dataset;

import java.util.Iterator;

import com.github.tcechal.ataccama.AggregateFn;
import com.github.tcechal.ataccama.DataSet;
import com.github.tcechal.ataccama.TransformFn;


public final class LazyDataSet<T, R> implements DataSet<T> {

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

package com.github.tcechal.ataccama.dataset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import com.github.tcechal.ataccama.AggregateFn;
import com.github.tcechal.ataccama.DataSet;
import com.github.tcechal.ataccama.Source;


public class MemoryDataSet<T> implements DataSet<T> {

    private final List<T> data = new ArrayList<>();


    public MemoryDataSet(Source<T> source) {

        source.forEach(data::add);
    }

    private <R> MemoryDataSet(Source<R> source, Function<R, T> transformFn) {

        source.forEach(r -> data.add(transformFn.apply(r)));
    }

    @Override
    public <R> DataSet<R> transform(Function<T, R> transformFn) {

        return new MemoryDataSet<>(this, transformFn);
    }

    @Override
    public <R> R aggregate(AggregateFn<T, R> aggregateFn) {

        return aggregateFn.aggregate(this);
    }

    @Override
    public Iterator<T> iterator() {

        return data.iterator();
    }
}

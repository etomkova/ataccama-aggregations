package com.github.tcechal.ataccama.dataset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.tcechal.ataccama.AggregateFn;
import com.github.tcechal.ataccama.DataSet;
import com.github.tcechal.ataccama.Source;
import com.github.tcechal.ataccama.TransformFn;


public class MemoryDataSet<T> implements DataSet<T> {

    private final List<T> data = new ArrayList<>();


    public MemoryDataSet(Source<T> source) {

        source.forEach(data::add);
    }

    private <R> MemoryDataSet(Source<R> source, TransformFn<R, T> transformFn) {

        source.forEach(r -> data.add(transformFn.transform(r)));
    }

    @Override
    public <R> DataSet<R> transform(TransformFn<T, R> transformFn) {

        return new MemoryDataSet<R>(this, transformFn);
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

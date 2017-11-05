package com.github.tcechal.ataccama.aggregations;

import com.github.tcechal.ataccama.sources.Source;

public interface Aggregator<T, R> {

    R aggregate(Source<T> input);
}

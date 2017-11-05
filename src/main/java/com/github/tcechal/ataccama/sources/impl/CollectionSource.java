package com.github.tcechal.ataccama.sources.impl;

import java.util.Collection;
import java.util.Iterator;

import com.github.tcechal.ataccama.sources.Source;


public class CollectionSource<T> implements Source<T> {

    private final Collection<T> items;


    public CollectionSource(Collection<T> items) {

        this.items = items;
    }

    @Override
    public Iterator<T> iterator() {

        return items.iterator();
    }
}

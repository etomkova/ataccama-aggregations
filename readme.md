# Simple data transfomation and aggregation library

This is just a trivial data processing library, meant as an excercise in API design.
It is certainly not intended for any kind of production use!

## Sample usage
```java
package com.github.tcechal.ataccama;

import com.github.tcechal.ataccama.aggregations.dataset.LazyDataSet;
import com.github.tcechal.ataccama.aggregations.lib.Ints;
import com.github.tcechal.ataccama.aggregations.source.From;


public class Driver {

    public static void main(String[] args) {

        System.out.println(LazyDataSet
                .create(From.array(new Integer[] {-2, -1, 0, 0, 1, 2}))
                .transform(Math::abs)
                .aggregate(Ints::mean));
    }
}
```


## Features

- Create a DataSet from various input sources

```java
// an array
Integer[] ints = {1, 2, 3};
DataSet<Integer> intSet = MemoryDataSet.create(From.array(ints));

// an iterable
List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0);
DataSet<Double> doubleSet = MemoryDataSet.create(From.iterable(doubles));

// a text file
String path = "data.txt";
DataSet<String> stringSet = MemoryDataSet.create(From.textFile(path));
```

- Different implementations of DataSet interface are provided

```java
Integer[] ints = {1, 2, 3};

// MemoryDataSet holds all the data in memory and performs transformations on the go
DataSet<Integer> eager = MemoryDataSet.create(From.array(ints));

// LazyDataSet records the requested operations and performs them only when required
// to produce some output
List<Double> doubles = Arrays.asList(1.0, 2.0, 3.0);
DataSet<Double> lazy = LazyDataSet.create(From.array(doubles));
```
- Two generic operations are supported on a DataSet
```java
Integer[] ints = {1, 2, 3};
DataSet<Integer> ds = MemoryDataSet.create(From.array(ints));

// transform maps each element of input data set into an element of the output data set
DataSet<Integer> transformed = ds.transform(x -> x + 1);
List<Integer> result = transformed.collect();
System.out.println(result); // prints [2, 3, 4]

// aggregate consumes the entire data set and produces a single output value
Integer result = ds.aggregate(Ints::max);
System.out.println(result); // prints 3
```
- in addition, two convenience aggregations are defined directly on DataSet
```java
Integer[] ints = {1, 2, 3};
DataSet<Integer> ds = MemoryDataSet.create(From.array(ints));

// collect() materializes the items contained in the data set into a list
System.out.println(ints.collect()) // prints [1, 2, 3]

// count() returns the total number of items in the data set
System.out.println(ints.count()) // prints 3
```
- transformations return a DataSet, so they can be chained; the chain ends with an aggregation
```java
String[] input = {"1", "2", "3"};
System.out.println(MemoryDataSet
    .create(From.array(input))
    .transform(Integer::parseInt)
    .aggregate(Ints::sum)) // prints 6
```
- `transform()` and `aggregate()` operations take an instance of the TransformFn and AggregateFn interfaces, respectively. Both are functional interfaces, meaning that method references and lambdas are supported as well as anonymous classes that directly implement these interfaces
```java
String[] input = {"1", "2", "3"};
DataSet<Integer> ds = MemoryDataSet
    .create(From.array(input))
    .transform(Integer::parseInt)
    .transform(x -> x + 1)
    .transform(
            new TransformFn<Integer, Integer>() {
                @Override
                public Integer transform(Integer item) {
                    return item + 1;
                }
            }));
```
- sample library aggregations for integers and doubles (max, mean and sum) are provided


## Limitations
- No support for advanced processing patterns such as filter, group by key etc.
- No parallel processing capabilities (single thread on local machine only)
- No abstractions for data sources and sinks are provided
- Immutability of underlying data sets is implied, but not enforced
- Type variance has not been taken into account
- Some corner cases are not tested
- Java 8 and above

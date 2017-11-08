package com.github.tcechal.ataccama;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import com.github.tcechal.ataccama.aggregations.dataset.LazyDataSet;
import com.github.tcechal.ataccama.aggregations.dataset.MemoryDataSet;
import com.github.tcechal.ataccama.aggregations.lib.Doubles;
import com.github.tcechal.ataccama.aggregations.lib.Ints;
import com.github.tcechal.ataccama.aggregations.source.From;


public class Driver {

    public static void main(String[] args) throws IOException {

        System.out.println(LazyDataSet
                .create(From.array(new Integer[] {-2, -1, 0, 0, 1, 2}))
                .transform(Math::abs)
                .aggregate(Ints::mean));

        System.out.println(MemoryDataSet
                .create(From.iterable(Arrays.asList(-2.0, -1.0, 0.0, 0.0, 1.0, 2.0)))
                .transform(Math::abs)
                .aggregate(Doubles::sum));

        System.out.println(MemoryDataSet
                .create(From.textFile(createTempFile()))
                .transform(Integer::parseInt)
                .aggregate(Ints::max));
    }

    private static String createTempFile() throws IOException {

        Path tempFile = Files.createTempFile("aggregation-input-", ".tmp");
        List<String> lines = Arrays.asList("1", "2", "3");
        Files.write(tempFile, lines, Charset.defaultCharset(), StandardOpenOption.WRITE);

        return tempFile.toString();
    }
}

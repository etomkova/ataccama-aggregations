package com.github.tcechal.ataccama.aggregations.source;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;


// Simple tests only (no deliberate failure injection, etc.).
public class TextFileLinesTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void getLines() throws IOException {

        List<String> input = Arrays.asList("dog", "cat");

        File tempFile = testFolder.newFile("data.txt");
        Files.write(tempFile.toPath(), input, StandardOpenOption.WRITE);

        List<String> output = new ArrayList<>(2);
        From.textFile(tempFile.getAbsolutePath()).forEach(output::add);

        Assert.assertEquals(input, output);
    }

    @Test
    public void emptyFile() throws IOException {

        File tempFile = testFolder.newFile("data.txt");

        List<String> output = new ArrayList<>();
        From.textFile(tempFile.getAbsolutePath()).forEach(output::add);

        Assert.assertEquals(0, output.size());
    }

    @Test(expected = IllegalStateException.class)
    public void nonExistingFile() throws Exception {

        List<String> output = new ArrayList<>();
        From.textFile("not.here").forEach(output::add);
    }
}

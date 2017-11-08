package com.github.tcechal.ataccama.aggregations.source;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Wraps a text file into an iterable of its lines.
 */
class TextFileLines implements Iterable<String> {

    // Custom iterator returning individual lines of the underlying textFile.
    private static final class LineIterator implements Iterator<String> {

        private BufferedReader reader;
        private String nextLine;


        private LineIterator(String path) {

            try {
                reader = new BufferedReader(new FileReader(path));
            } catch (FileNotFoundException e) {  // No checked exceptions allowed by Iterable interface.
                throw new IllegalStateException(e);
            }

            readNextLine();
        }

        private void readNextLine() {

            // EOF reached, nothing to read.
            if (reader == null) {
                return;
            }

            try {
                nextLine = reader.readLine();
            } catch (IOException e) {  // No checked exceptions allowed by Iterable interface.
                close();
                throw new IllegalStateException(e);
            }

            // EOF reached, close the underlying textFile.
            if (nextLine == null) {
                close();
            }
        }

        private void close() {

            if (reader == null) {
                return;
            }

            try {
                reader.close();
            } catch (IOException e) {  // No checked exceptions allowed by Iterable interface.
                throw new IllegalStateException(e);
            } finally {
                reader = null;
            }
        }

        @Override
        public boolean hasNext() {

            return nextLine != null;
        }

        @Override
        public String next() {

            if (hasNext()) {
                String currentLine = nextLine;
                readNextLine();
                return currentLine;
            } else {
                throw new NoSuchElementException();
            }
        }
    }


    private final String path;


    TextFileLines(String path) {

        this.path = path;
    }

    @Override
    public Iterator<String> iterator() {

        return new LineIterator(path);
    }
}

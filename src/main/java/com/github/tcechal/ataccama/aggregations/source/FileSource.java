package com.github.tcechal.ataccama.aggregations.source;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class FileSource implements Iterable<String> {

    private static class LineIterator implements Iterator<String> {

        private BufferedReader reader;
        private String nextLine;


        private LineIterator(String path) {

            try {
                reader = new BufferedReader(new FileReader(path));
            } catch (FileNotFoundException e) {
                throw new IllegalStateException(e);
            }

            readNext();
        }

        private void readNext() {
            try {
                nextLine = reader.readLine();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        private void dispose() {

            if (reader == null) {
                return;
            }

            try {
                reader.close();
                reader = null;
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public boolean hasNext() {

            if (nextLine == null) {
                dispose();
                return false;
            } else {
                return true;
            }
        }

        @Override
        public String next() {

            if (hasNext()) {
                String line = nextLine;
                readNext();
                return line;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    private final String path;


    public FileSource(String path) {

        this.path = path;
    }

    @Override
    public Iterator<String> iterator() {

        return new LineIterator(path);
    }
}

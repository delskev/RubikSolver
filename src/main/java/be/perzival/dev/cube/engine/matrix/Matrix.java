package be.perzival.dev.cube.engine.matrix;

import be.perzival.dev.cube.exception.DataValidationException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static be.perzival.dev.cube.engine.matrix.MatrixValidator.validateBoundaries;
import static be.perzival.dev.cube.engine.matrix.MatrixValidator.validateNewData;

public class Matrix<T> implements Iterable<T>{
    private final int height;
    private final int width;
    private final T[][] elements;

    public Matrix(int height, int width) {
        this.height = height;
        this.width = width;
        this.elements = (T[][]) new Object[height][width];

    }

    public int size() {
        return (int) toStream().filter(Objects::nonNull).count();
    }

    public boolean isEmpty() {
        return toStream().noneMatch(Objects::nonNull);
    }

    public Stream<T> toStream() {
        return Arrays.stream(this.elements)
                .flatMap(Stream::of);
    }

    public boolean contains(Object objectToFind) {
        return toStream().anyMatch(objectToFind::equals);
    }

    public void add(T element, int row, int column) {
        validateBoundaries(this.height, this.width, row, column);
        elements[row][column] = element;
    }

    public void fill(T element) {
        IntStream.range(0, this.height * this.width)
                .forEach(i -> this.elements[i % this.height][i / this.height] = element);
    }

    public T get(int row, int column) {
        validateBoundaries(this.height, this.width, row, column);
        return this.elements[row][column];
    }

    public List<T> getRow(int row) {
        return IntStream.range(0, this.width).boxed()
                .map(i -> this.elements[row][i])
                .collect(Collectors.toList());
    }

    public List<T> getColumn(int column) {
        return IntStream.range(0, this.width).boxed()
                .map(i -> this.elements[i][column])
                .collect(Collectors.toList());
    }

    /**
     * replace a specified row in the matrix
     * @param row the row index to replace
     * @param newRow the new data row
     * @return the old row
     * @throws DataValidationException
     */
    public List<T> replaceRow(int row, List<T> newRow) throws DataValidationException {
        validateNewData(newRow, this.width);
        return IntStream.range(0, this.width).boxed()
                .map(i -> replaceElement(row, i, newRow.get(i)))
                .collect(Collectors.toList());
    }

    /**
     * replace a specified colomn in the matrix
     * @param column the column index to replace
     * @param newColumn the new data column
     * @return the old column
     * @throws DataValidationException
     */
    public List<T> replaceColumn(int column, List<T> newColumn) throws DataValidationException {
        validateNewData(newColumn, this.height);
        return IntStream.range(0, this.width).boxed()
                .map(i -> replaceElement(i, column, newColumn.get(i)))
                .collect(Collectors.toList());
    }

    public void remove(int row, int column) {
        replaceElement(row, column, null);
    }

    public void clear() {
        IntStream.range(0, this.height * this.width)
                .forEach(i -> this.elements[i % this.height][i / this.height] = null);
    }

    private T replaceElement(int row, int column, T newElement) {
        var oldElement = this.elements[row][column];
        this.elements[row][column] = newElement;
        return oldElement;
    }

    public Stream<T> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    @Override
    public Iterator<T> iterator() {
        return new MatrixIterator();
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.elements);
    }

    class MatrixIterator implements Iterator<T> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < Matrix.this.height * Matrix.this.width;
        }

        @Override
        public T next() {
            if(!hasNext()){ throw new NoSuchElementException();}
            var oldCursor = cursor++;
            return Matrix.this.get(oldCursor / Matrix.this.width, oldCursor % Matrix.this.width);
        }
    }
}

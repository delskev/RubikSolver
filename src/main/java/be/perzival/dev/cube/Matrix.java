package be.perzival.dev.cube;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class Matrix<T> {
    private final int row;
    private final int column;
    private int size;
    private final T[][] elements;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.size = 0;
        this.elements = (T[][]) new Object[row][column];
    }


    /**
     * return the number of element present in the list
     * i.e: non-null element
     *
     * @return the amount of non null elements
     */
    public int size() {
        return this.size;
    }

    /**
     * Check if the matrix is completely empty
     *
     * @return true if all element are null (i.e: empty)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * verify if the matrix contain the provided Object
     *
     * @param objectToFind
     * @return true if founded false if not
     */
    public boolean contains(Object objectToFind) {
        return IntStream.range(0, this.row * this.column)
                .anyMatch(index -> objectToFind.equals(get(index % row, index / row)));
    }

    /**
     * Add an element to the initial matrix
     * replace if an element already exists
     *
     * @param element the element to insert. Must not be null
     * @param row     the row index
     * @param column  the column index
     * @return true if successful
     */
    public boolean add(T element, int row, int column) {
        Objects.requireNonNull(element);
        validateBoundaries(row, column);
        elements[row][column] = element;
        this.size++;
        return true;
    }

    /**
     * get an element at specific row column
     *
     * @param row    row index
     * @param column column index
     * @return the element or null if not found
     */
    public T get(int row, int column) {
        validateBoundaries(row, column);
        return this.elements[row][column];
    }

    /**
     * Remove an element at a specified coordinate
     * @param row
     * @param column
     * @return if the operation is successful
     */
    public boolean remove(int row, int column) {
        validateBoundaries(row, column);
        this.elements[row][column] = null;
        return true;
    }

    /**
     * Remove all elements from the matrix
     */
    public void clear() {
        IntStream.range(0, this.row  * this.column)
                .forEach(i -> this.elements[i % this.row][i / this.row] = null);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("[\n");
        for (int i = 0; i < this.row; i++) {
            builder.append("{");
            for (int j = 0; j < this.column; j++) {
                builder.append(this.elements[i][j])
                        .append(j + 1 < this.column ? ", " : "");
            }
            builder.append("}\n");
        }
        return builder.append("]").toString();
    }

    private void validateBoundaries(int row, int column) {
        if (row >= this.row || column >= this.column) {
            throw new IndexOutOfBoundsException("Index out of range: [" + row + ";" + column + "]");
        }
    }
}
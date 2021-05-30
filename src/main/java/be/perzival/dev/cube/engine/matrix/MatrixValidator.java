package be.perzival.dev.cube.engine.matrix;

import be.perzival.dev.cube.exception.DataValidationException;

import java.util.List;

public interface MatrixValidator {
    static void validateBoundaries(int height, int width, int row, int column) {
        if (row >= height || column >= width) {
            throw new IndexOutOfBoundsException("Index out of range: [" + row + ";" + column + "]");
        }
    }

    static <T> void validateNewData(List<T> newData, int expectedSize) throws DataValidationException {
        if (newData == null || newData.size() != expectedSize) {
            throw new DataValidationException(newData);
        }
    }
}

package be.perzival.dev.cube;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatrixOperation {

    private MatrixOperation() {
        //Utils class
    }

    public static <T> List<T> getLineByIndex(final Matrix<T> matrix, int lineIndex) {
//        return Arrays.stream(matrix[lineIndex]).collect(Collectors.toList());
        return Collections.emptyList();
    }

    public static <T> List<T> getColumnByIndex(final T[][] matrix, int columnIndex) {
        return IntStream.range(0, matrix[0].length).boxed()
                .map(index -> matrix[index][columnIndex])
                .collect(Collectors.toList());
    }

    public static <T> T[][] replaceLine(T[][] matrix, final T[] newValues, int rowIndex) {
        T[][] copy = copy(matrix);
        IntStream.range(0, rowIndex).boxed().forEach(i -> copy[i][rowIndex] = newValues[i]);

        return copy;
    }

    private static final <T> T[][] copy(T[][] original) {
        T[][] copy = (T[][]) new Object[original.length][];
        for (var i = 0; i < original.length; ++i) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return copy;
    }
}

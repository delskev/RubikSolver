package be.perzival.dev.cube;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MatrixOperation {

    private MatrixOperation() {
        //Utils class
    }

    public static <T> List<T> getLineByIndex(final T[][] matrix, int lineIndex) {
        return Arrays.stream(matrix[lineIndex]).collect(Collectors.toList());
//        return IntStream.range(0, matrix.length).boxed()
//                .map(index -> matrix[lineIndex][index])
//                .collect(Collectors.toList());
    }

    public static <T> List<T> getColumnByIndex(final T[][] matrix, int columnIndex) {
        return IntStream.range(0, matrix[0].length).boxed()
                .map(index -> matrix[index][columnIndex])
                .collect(Collectors.toList());
    }
}

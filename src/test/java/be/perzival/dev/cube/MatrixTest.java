package be.perzival.dev.cube;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MatrixTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1", "2, 2", "3, 3", "4, 4", "5, 5",
            "6, 6", "7, 7", "8, 8", "9, 9", "10, 10",
            "11, 11", "13, 13", "17, 17"
    })
    void addElement(int row, int column) {
        //given
        Matrix<String> matrix = new Matrix(row, column);
        //when
        matrix.add("Hello", 0, 0);
        matrix.add("Hello", row - 1, column - 1);
        //then
        Assertions.assertThat(matrix.get(0, 0)).isNotNull();
        Assertions.assertThat(matrix.get(row - 1, column - 1)).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1", "2, 2", "3, 3", "4, 4", "5, 5",
            "6, 6", "7, 7", "8, 8", "9, 9", "10, 10",
            "11, 11", "13, 13", "17, 17"
    })
    void getRow(int row, int column) {
        //given
        Matrix<Integer> matrix = new Matrix(row, column);
        IntStream.range(0,column).forEach(i -> matrix.add(i+1, 0, i));
        //when
        Vector actualRow = matrix.getRow(0);
        //then
        Vector<Integer> expectedRow = IntStream.rangeClosed(1, column).boxed().collect(Collectors.toCollection(Vector::new));
        Assertions.assertThat(actualRow).isEqualTo(expectedRow);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1", "2, 2", "3, 3", "4, 4", "5, 5",
            "6, 6", "7, 7", "8, 8", "9, 9", "10, 10",
            "11, 11", "13, 13", "17, 17"
    })
    void getColumn(int row, int column) {
        //given
        Matrix<Integer> matrix = new Matrix(row, column);
        IntStream.range(0,column).forEach(i -> matrix.add(i+1, i, i / row));
        //when
        Vector actualRow = matrix.getColumn(0);
        //then
        Vector<Integer> expectedColumn = IntStream.rangeClosed(1, row).boxed().collect(Collectors.toCollection(Vector::new));
        Assertions.assertThat(actualRow).isEqualTo(expectedColumn);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1", "2, 2", "3, 3", "4, 4", "5, 5",
            "6, 6", "7, 7", "8, 8", "9, 9", "10, 10",
            "11, 11", "13, 13", "17, 17"
    })
    void removeElement(int row, int column) {
        //given
        String objectToRemove = "Hallo";
        Matrix<String> matrix = new Matrix(row, column);

        matrix.add("Hello", 0, 0);
        //when
        matrix.remove(0, 0);
        //then
        Assertions.assertThat(matrix.get(0, 0)).isNull();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1", "2, 2", "3, 3", "4, 4", "5, 5",
            "6, 6", "7, 7", "8, 8", "9, 9", "10, 10",
            "11, 11", "13, 13", "17, 17"
    })
    void containsElement(int row, int column) {
        //given
        String objectToFind = "Hallo";
        Matrix<String> matrix = new Matrix(row, column);
        matrix.add(objectToFind, 0, 0);
        //when
        boolean result = matrix.contains(objectToFind);
        //then
        Assertions.assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1", "2, 2", "3, 3", "4, 4", "5, 5",
            "6, 6", "7, 7", "8, 8", "9, 9", "10, 10",
            "11, 11", "13, 13", "17, 17"
    })
    void isEmpty(int row, int column) {
        //given
        Matrix<String> emptyMatrix = new Matrix(row, column);
        Matrix<String> filledMatrix = new Matrix(row, column);
        //when
        filledMatrix.add("Hello", 0, 0);
        boolean isEmpty = emptyMatrix.isEmpty();
        boolean isFilled = filledMatrix.isEmpty();
        //then
        Assertions.assertThat(emptyMatrix.size()).isZero();
        Assertions.assertThat(filledMatrix.size()).isEqualTo(1);

        Assertions.assertThat(isEmpty).isTrue();
        Assertions.assertThat(isFilled).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1", "2, 2", "3, 3", "4, 4", "5, 5",
            "6, 6", "7, 7", "8, 8", "9, 9", "10, 10",
            "11, 11", "13, 13", "17, 17"
    })
    void clearMatrix(int row, int column) {
        //given
        Matrix<String> matrix = new Matrix(row, column);
        IntStream.range(0, row * column).forEach(i -> matrix.add("Hello", i % row, i / row));
        //when
        matrix.clear();
        //then
        IntStream.range(0, row * column)
                .forEach(i ->
                        Assertions.assertThat(matrix.get(i % row, i / row)).isNull()
                );
    }
}

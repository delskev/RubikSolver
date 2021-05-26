package be.perzival.dev.cube;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class Matrix2X2Test {

    @Test
    void addElement() {
        //given
        Matrix<String> matrix = new Matrix(2, 2);
        //when
        boolean result1 = matrix.add("Hello", 0, 0);
        boolean result2 = matrix.add("Hallo", 0, 1);
        //then
        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
        Assertions.assertThat(matrix.get(0, 0)).isNotNull();
        Assertions.assertThat(matrix.get(0, 1)).isNotNull();
        Assertions.assertThat(matrix.get(1, 0)).isNull();
    }

    @Test
    void removeElement() {
        //given
        String objectToRemove = "Hallo";
        Matrix<String> matrix = new Matrix(2, 2);
        matrix.add("Hello", 0, 0);
        matrix.add(objectToRemove, 0, 1);
        //when
        boolean result = matrix.remove(0, 1);
        //then
        Assertions.assertThat(result).isTrue();
        Assertions.assertThat(matrix.get(0, 0)).isNotNull();
        Assertions.assertThat(matrix.get(0, 1)).isNull();
    }

    @Test
    void containsElement() {
        //given
        String objectToFind = "Hallo";
        Matrix<String> matrix = new Matrix(2, 2);
        matrix.add("Hello", 0, 0);
        matrix.add(objectToFind, 0, 1);
        //when
        boolean result = matrix.contains(objectToFind);
        //then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void isEmpty() {
        //given
        Matrix<String> emptyMatrix = new Matrix(2, 2);
        Matrix<String> filledMatrix = new Matrix(2, 2);
        //when
        filledMatrix.add("Hello", 0, 0);
        //then
        Assertions.assertThat(emptyMatrix.size()).isZero();
        Assertions.assertThat(filledMatrix.size()).isEqualTo(1);

        Assertions.assertThat(emptyMatrix.isEmpty()).isTrue();
        Assertions.assertThat(filledMatrix.isEmpty()).isFalse();
    }

    @Test
    void clearMatrix() {
        //given
        Matrix<String> matrix = new Matrix(2, 2);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix.add("Hello", i, j);
            }
        }
        //when
        matrix.clear();
        //then
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Assertions.assertThat(matrix.get(i, j)).isNull();
            }
        }
    }

    @Test
    void toStringMatrix() {
        //given
        Matrix<String> matrix = new Matrix(2, 2);
        IntStream.range(0, 4)
                .forEach(i -> matrix.add("Hello", i % 2, i / 2));
        //when
        matrix.remove(1, 1);
        String result = matrix.toString();

        //then
        Assertions.assertThat(result).isEqualTo(
                "[\n" +
                    "{Hello, Hello}\n" +
                    "{Hello, null}\n" +
                "]");
    }
}

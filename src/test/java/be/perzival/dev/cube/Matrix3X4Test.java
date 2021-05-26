package be.perzival.dev.cube;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class Matrix3X4Test {


    @Test
    void addElement() {
        //given
        Matrix<String> matrix = new Matrix(3, 4);
        //when
        boolean result1 = matrix.add("Hello", 0, 0);
        boolean result2 = matrix.add("Hallo", 0, 1);
        boolean result3 = matrix.add("world", 0, 2);
        //then
        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
        Assertions.assertThat(result3).isTrue();
        Assertions.assertThat(matrix.get(0, 0)).isNotNull();
        Assertions.assertThat(matrix.get(0, 1)).isNotNull();
        Assertions.assertThat(matrix.get(0, 2)).isNotNull();
        Assertions.assertThat(matrix.get(1, 0)).isNull();
    }

    @Test
    void removeElement() {
        //given
        String objectToRemove = "Hallo";
        Matrix<String> matrix = new Matrix(3, 4);
        matrix.add("Hello", 0, 0);
        matrix.add(objectToRemove, 0, 1);
        matrix.add("world", 0, 2);
        //when
        boolean result = matrix.remove(0, 1);
        //then
        Assertions.assertThat(result).isTrue();
        Assertions.assertThat(matrix.get(0, 0)).isNotNull();
        Assertions.assertThat(matrix.get(0, 1)).isNull();
        Assertions.assertThat(matrix.get(0, 2)).isNotNull();
    }

    @Test
    void containsElement() {
        //given
        String objectToFind = "Hallo";
        Matrix<String> matrix = new Matrix(3, 4);
        matrix.add("Hello", 0, 0);
        matrix.add(objectToFind, 0, 1);
        matrix.add("world", 0, 2);
        //when
        boolean result = matrix.contains(objectToFind);
        //then
        Assertions.assertThat(result).isTrue();
    }

    @Test
    void isEmpty() {
        //given
        Matrix<String> emptyMatrix = new Matrix(3, 4);
        Matrix<String> filledMatrix = new Matrix(3, 4);
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
        Matrix<String> matrix = new Matrix(3, 4);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                matrix.add("Hello", i, j);
            }
        }
        //when
        matrix.clear();
        //then
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Assertions.assertThat(matrix.get(i, j)).isNull();
            }
        }
    }

    @Test
    void toStringMatrix() {
        //given
        Matrix<String> matrix = new Matrix(3, 4);
        IntStream.range(0, 12)
                .forEach(i -> matrix.add("Hello", i % 3, i / 3));
        //when
        matrix.remove(1, 1);
        String result = matrix.toString();

        //then
        Assertions.assertThat(result).isEqualTo(
                "[\n" +
                    "{Hello, Hello, Hello, Hello}\n" +
                    "{Hello, null, Hello, Hello}\n" +
                    "{Hello, Hello, Hello, Hello}\n" +
                "]");
    }


}

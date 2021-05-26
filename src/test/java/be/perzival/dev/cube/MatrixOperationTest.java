package be.perzival.dev.cube;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixOperationTest {

    @Test
    void name() {
        //given
        //when
        //then
        int[][] exampleVariableOne = new int[10][5];
        Object[][] exampleVariableTwo = new Object[10][5];

        // returns the length of the rows in the array
        int lengthOne = exampleVariableOne.length;
        // returns the length of the columns in the array
        int lengthTwo = exampleVariableOne[1].length;
    }

    @Test
    void name2() {
        String[][] elements = new String[][] {{"Hello", "world"}, {"foo", "zut"}};
        boolean result = Arrays.stream(elements)
                .flatMap(row -> Arrays.stream(row))
                .noneMatch(element -> element != null);

        String[][] elements2 = new String[3][3];
        boolean result2 = Arrays.stream(elements2)
                .flatMap(row -> Arrays.stream(row))
                .noneMatch(element -> element != null);

        var result3 = Arrays.stream(elements2)
                .flatMap(row -> Arrays.stream(row))
                .takeWhile(element -> element != null)
                .count();

        var result4 = Arrays.stream(elements2)
                .flatMap(row -> Arrays.stream(row))
                .takeWhile(element -> element != null)
                .count();
    }

    @Test
    void getLineTest() {
        //given
        Integer[][] numbers = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //when
        List<Integer> ActualLine0 = MatrixOperation.getLineByIndex(numbers, 0);
        List<Integer> ActualLine1 = MatrixOperation.getLineByIndex(numbers, 1);
        List<Integer> ActualLine2 = MatrixOperation.getLineByIndex(numbers, 2);
        //then

        Assertions.assertThat(ActualLine0.toArray(Integer[]::new)).isEqualTo(numbers[0]);
        Assertions.assertThat(ActualLine1.toArray(Integer[]::new)).isEqualTo(numbers[1]);
        Assertions.assertThat(ActualLine2.toArray(Integer[]::new)).isEqualTo(numbers[2]);
    }

    @Test
    void getColumnTest() {
        //given
        Integer[][] numbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        //when
        List<Integer> ActualLine0 = MatrixOperation.getColumnByIndex(numbers, 0);
        List<Integer> ActualLine1 = MatrixOperation.getColumnByIndex(numbers, 1);
        List<Integer> ActualLine2 = MatrixOperation.getColumnByIndex(numbers, 2);
        //then

        Assertions.assertThat(ActualLine0.toArray(Integer[]::new)).isEqualTo(new Integer[]{1, 4, 7});
        Assertions.assertThat(ActualLine1.toArray(Integer[]::new)).isEqualTo(new Integer[]{2, 5, 8});
        Assertions.assertThat(ActualLine2.toArray(Integer[]::new)).isEqualTo(new Integer[]{3, 6, 9});
    }
}

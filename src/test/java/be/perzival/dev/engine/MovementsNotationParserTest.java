package be.perzival.dev.engine;

import be.perzival.dev.cube.engine.movement.Movement;
import be.perzival.dev.cube.engine.movement.MovementsNotationsParser;

import be.perzival.dev.cube.exception.BadMovementException;
import be.perzival.dev.cube.exception.NotationIsInvalidException;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

class MovementsNotationParserTest {


    @ParameterizedTest
    @ValueSource(strings = {
            "B2 F2 U' B' F' L' D2 R F R' F B2 D2 L B' R' U L U L D2 R2 D F' D'",
            "L2 U B D2 L2 U2 F' L2 R' B U R F' B2 U' L2 U R L' F' U2 F2 U2 B2 L",
            "R F' D2 L2 U' R F R D2 F' U' R' B' L R2 D B2 L2 F2 B' L2 R2 U2 B' R2",
            "D2 L' R2 U2 R2 D R D B2 U R2 F U' F2 L2 B U' D B' F' D B2 U L' B'",
            "U F' D2 L B L F' L' F' U2 R' D2 U' B L' B R U' D2 F' U D' L2 R B'"
    })
    void goodScramble(String notations)  {
        //given
        String[] expectedMovements = notations.split(MovementsNotationsParser.NOTATION_SPLITTER);
        //when
        List<Movement> actualMovementList = Assertions.assertDoesNotThrow(() -> MovementsNotationsParser.of(notations).parse());
        //then
        Assertions.assertEquals(expectedMovements.length, actualMovementList.size());
        IntStream.range(0, actualMovementList.size()).boxed()
                .map(i -> Pair.of(expectedMovements[i], actualMovementList.get(i).getNotation()))
                .forEach(expectedAndActual -> Assertions.assertEquals(expectedAndActual.getLeft(), expectedAndActual.getRight()));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "B2'",
    })
    void BadScramble(String expectedMovements)  {
        //when
        Assertions.assertThrows(NotationIsInvalidException.class, () -> MovementsNotationsParser.of(expectedMovements).parse());
        //then
    }

}

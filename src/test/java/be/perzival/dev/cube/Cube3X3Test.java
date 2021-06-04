package be.perzival.dev.cube;

import be.perzival.dev.cube.engine.movement.Movement;
import be.perzival.dev.cube.engine.movement.MovementType;
import be.perzival.dev.cube.exception.BadMovementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class Cube3X3Test {



    @ParameterizedTest
    @ValueSource(strings = {
            "U", "U'", "U2", "u","u'", "u2",
            "D", "D'", "D2", "d","d'", "d2",
            "L", "L'", "L2", "l","l'", "l2",
            "R", "R'", "R2", "r","r'", "r2",
            "B", "B'", "B2", "b","b'", "b2",
            "F", "F'", "F2", "f","f'", "f2",})
    void movementNotationTest_OK(String testedMovement) {
        //given
        Cube3X3 rubik = new Cube3X3();
        //when
        Assertions.assertDoesNotThrow(() -> rubik.move(testedMovement));
        //then
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "Z", "c", "Up", "be", "ub'", "u3", "E'"})
    void movementNotationTest_NOK(String testedMovement) throws BadMovementException {
        //given
        Cube3X3 rubik = new Cube3X3();
        //when
        Assertions.assertThrows(BadMovementException.class, () -> rubik.move(testedMovement));
        //then
    }

    @Test
    void movementUp_Ok() throws BadMovementException {
        //given
        Cube3X3 rubik = new Cube3X3();
        //when
        Assertions.assertDoesNotThrow(() -> rubik.move("u"));
        //then

    }
}

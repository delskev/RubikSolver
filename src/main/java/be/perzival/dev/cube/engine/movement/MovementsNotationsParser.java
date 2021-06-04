package be.perzival.dev.cube.engine.movement;

import be.perzival.dev.cube.engine.utils.ThrowingFunction;
import be.perzival.dev.cube.engine.validators.NotationValidator;

import java.util.List;
import java.util.stream.Collectors;

public class MovementsNotationsParser {
    public static final String NOTATION_SPLITTER = " ";

    private final List<String> notations;

    public static final MovementsNotationsParser of(String annotations) {
        return new MovementsNotationsParser(annotations);
    }

    public MovementsNotationsParser(String notations) {
        this.notations = List.of(notations.split(NOTATION_SPLITTER));
    }

    public List<Movement> parse() {
        return this.notations.stream()
                .map(ThrowingFunction.unchecked(NotationValidator::validate))
                .map(MovementsNotationsParser::toMovement)
                .collect(Collectors.toList());
    }

    private static Movement toMovement(String notation)  {
        char[] splittedNotation = notation.toCharArray();

        return notation.length() == 2 ?
                Movement.of(MovementType.of(splittedNotation[0]), splittedNotation[1] == '2',splittedNotation[1] != '\'') :
                Movement.of(MovementType.of(splittedNotation[0]),false,true);
    }


}

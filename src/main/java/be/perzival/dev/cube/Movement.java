package be.perzival.dev.cube;

import be.perzival.dev.cube.exception.NotationIsInvalid;
import be.perzival.dev.cube.exception.WrongSideException;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class Movement {
    private final Cube.FaceSide sideToMove;
    private final int iteration;
    private final boolean clockwise;

    public static Movement of(Cube.FaceSide sideToMove, int iteration, boolean isClockwise) {
        return new Movement(sideToMove, iteration, isClockwise);
    }

    public static Movement of(String notation) throws NotationIsInvalid, WrongSideException {
        isNotationValid(notation);

        char[] splittedNotation = notation.toCharArray();
        return splittedNotation.length == 2 ?
                new Movement(Cube.FaceSide.valueFrom(splittedNotation[0]), splittedNotation[1] == '2' ? 2 : 1,splittedNotation[1] != '\'') :
                new Movement(Cube.FaceSide.valueFrom(splittedNotation[0]),1,true);
    }

    private Movement(Cube.FaceSide sideToMove, int iteration, boolean clockwise) {
        this.sideToMove = sideToMove;
        this.iteration = iteration;
        this.clockwise = clockwise;
    }

    public Cube.FaceSide getSideToMove() {
        return sideToMove;
    }

    public int getIteration() {
        return iteration;
    }

    public boolean isClockwise() {
        return clockwise;
    }

    public String getNotation() {
        return new StringBuilder(this.sideToMove.toStandardAnnotation())
                .append(this.iteration == 1 ? "" : 2)
                .append(this.isClockwise() ? "" : "'")
                .toString();
    }

    public static final boolean isNotationValid(String notation) throws NotationIsInvalid {
        if( StringUtils.isAllEmpty(notation) || notation.length() <= 3 && Pattern.matches("[UDBFRLudbfrl]{1}[2']?[']?", notation)) {
            throw new NotationIsInvalid(notation);
        }
        return true;
    }


    @Override
    public String toString() {
        return "Movement{" +
                "Notation=" + this.getNotation() +
                ", sideToMove=" + sideToMove +
                ", iteration=" + iteration +
                ", clockwise=" + clockwise +
                '}';
    }
}

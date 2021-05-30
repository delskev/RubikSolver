package be.perzival.dev.cube.exception;

import be.perzival.dev.cube.engine.Cell;

import java.util.Arrays;

public class TooManyCellsException extends Exception {
    private static final String ERROR_MESSAGE = "The new cells provided is too big: ";

    public TooManyCellsException(Cell[] newLine) {
        super(ERROR_MESSAGE.concat(Arrays.toString(newLine)));
    }
}

package be.perzival.dev.cube.exception;

public class NotationIsInvalid extends Exception {
    private static final String ERROR_MESSAGE = "The notation provided is not a valid one: ";

    public NotationIsInvalid(String notation) {
        super(ERROR_MESSAGE.concat(notation));
    }
}

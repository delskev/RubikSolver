package be.perzival.dev.cube.exception;

public class NotationIsInvalidException extends Exception {
    private static final String ERROR_MESSAGE = "The notation provided is not a valid one: ";

    public NotationIsInvalidException(String notation, String errors) {
        super(ERROR_MESSAGE.concat(notation).concat("\n").concat(errors));
    }

    public NotationIsInvalidException() {
    }
}

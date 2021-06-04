package be.perzival.dev.cube.exception;

public class BadMovementException extends Exception {
    private static final String ERROR_MESSAGE= "The provided WrongSideException is incorrect: ";

    public BadMovementException(String message) {
        super(ERROR_MESSAGE.concat(message));
    }
}

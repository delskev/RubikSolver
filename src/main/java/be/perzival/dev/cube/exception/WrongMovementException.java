package be.perzival.dev.cube.exception;

public class WrongMovementException extends Exception {
    private static final String ERROR_MESSAGE= "The provided side is incorrect: ";


    public WrongMovementException(String side) {
        super(ERROR_MESSAGE.concat(side));
    }
}

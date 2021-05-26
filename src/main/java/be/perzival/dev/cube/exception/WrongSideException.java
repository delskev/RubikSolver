package be.perzival.dev.cube.exception;

public class WrongSideException extends Exception {
    private static final String ERROR_MESSAGE= "The provided side is incorrect: ";


    public WrongSideException(String side) {
        super(ERROR_MESSAGE.concat(side));
    }
}

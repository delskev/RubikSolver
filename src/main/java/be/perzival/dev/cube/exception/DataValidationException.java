package be.perzival.dev.cube.exception;

import java.util.List;

public class DataValidationException extends Exception {
    private static final String ERROR_MESSAGE_NULL = "The provided data are null ";
    private static final String ERROR_MESSAGE_TOO_BIG = "The provided data has different size: ";

    public <T> DataValidationException(List<T> vector) {
        super(vector == null ?
                ERROR_MESSAGE_NULL:
                ERROR_MESSAGE_TOO_BIG.concat(vector.toString()));
    }
}

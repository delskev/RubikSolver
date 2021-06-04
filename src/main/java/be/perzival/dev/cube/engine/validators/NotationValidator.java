package be.perzival.dev.cube.engine.validators;

import be.perzival.dev.cube.exception.NotationIsInvalidException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public interface NotationValidator {

    enum NotationValidation {
        LENGTH_VALIDATION(notation -> notation.length() <= 2, "Length should be less than 3"),
        PATTERN_VALIDATION(notation -> Pattern.matches("[UDBFRLudbfrl]{1}[2']?[']?", notation), "The notation does not math with the pattern");

        private final Predicate<String> predicate;
        private final String errorMessage;

        NotationValidation(Predicate<String> predicate, String errorMessage) {
            this.predicate = predicate;
            this.errorMessage = errorMessage;
        }

        public Predicate<String> getTest() {
            return predicate;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public boolean test(String notation) {
            return this.predicate.test(notation);
        }
    }

    static String validate(String notation) throws NotationIsInvalidException {
        String collect = Arrays.stream(NotationValidation.values())
                .filter(notationValidation -> !notationValidation.test(notation))
                .map(NotationValidation::getErrorMessage)
                .collect(Collectors.joining("\n"));

        if( !StringUtils.isEmpty(collect)) {
            throw new NotationIsInvalidException(notation, collect);
        }
        return notation;
    }

}

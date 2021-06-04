package be.perzival.dev.cube.engine.utils;

import java.util.function.Predicate;

public interface ThrowingPredicate<T> {
    boolean test(T t) throws Exception;

    @SuppressWarnings("unchecked")
    static <T extends Exception> boolean sneakyThrow(Exception t) throws T {
        throw (T) t;
    }

    static <T> Predicate<T> unchecked(ThrowingPredicate<T> f) {
        return t -> {
            try {
                return f.test(t);
            } catch (Exception ex) {
                return ThrowingPredicate.sneakyThrow(ex);
            }
        };
    }
}
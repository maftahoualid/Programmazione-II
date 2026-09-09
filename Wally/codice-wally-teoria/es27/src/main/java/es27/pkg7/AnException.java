package es27.pkg7;

/**
 * Slide 27 e 28 di T17: "Exceptions and Loops".
 *
 * Eccezione checked personalizzata denominata 'AnException'
 * esattamente come indicato nel codice di esempio delle slide di teoria.
 */
public class AnException extends Exception {

    public AnException(String message) {
        super(message);
    }

    public AnException(String message, Throwable cause) {
        super(message, cause);
    }
}

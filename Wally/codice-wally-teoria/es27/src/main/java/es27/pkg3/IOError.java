package es27.pkg3;

public class IOError extends Exception {
    public IOError(String message) {
        super(message);
    }

    public IOError() {
        super("I/O error");
    }
}

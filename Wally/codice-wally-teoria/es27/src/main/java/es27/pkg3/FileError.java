package es27.pkg3;

public class FileError extends Exception {
    public FileError(String message) {
        super(message);
    }

    public FileError() {
        super("File error error");
    }
}

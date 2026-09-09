package es27.pkg4;

// Eccezione Checked (estende direttamente Exception)
public class MyException extends Exception {
    public MyException() {
        super("MyException Checked originale!");
    }

    public MyException(String message) {
        super(message);
    }
}

package es27.pkg2;

/**
 * 1. Dichiarazione di una classe di eccezione personalizzata (Checked Exception).
 *
 * Estendendo Exception (e non RuntimeException), questa classe rappresenta
 * un'eccezione checked: i metodi che la sollevano sono obbligati a dichiararla
 * con throws, e i chiamanti sono obbligati a gestirla con try-catch o propagarla.
 */
public class EmptyStackException extends Exception {

    // Se non dichiaro un costruttore : ne viene dichiarato uno vuoto di default che chiama quello di Exception

    public EmptyStackException(Stack stack) {
        super("Pop Failure - stack " + stack.toString() + " empty]");
    }
}

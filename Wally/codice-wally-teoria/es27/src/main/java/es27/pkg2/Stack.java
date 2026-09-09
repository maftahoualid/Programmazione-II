package es27.pkg2;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Stack che dimostra:
 * 2. Dichiarazione di 'throws EmptyStackException' nella firma del metodo.
 * 3 & 4. Istanziazione e lancio ('throw') dell'eccezione custom.
 */
public class Stack {
    private final List<Object> elements = new ArrayList<>();

    public void push(Object o) {
        elements.add(o);
    }

    // 2. Mark the method raising the exception
    public Object pop() throws EmptyStackException {
        if (elements.isEmpty()) {
            // 3 & 4. Instantiate and throw up the exception
            throw new EmptyStackException(this);
        }
        return elements.remove(elements.size() - 1);
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public String toString() {
        return "[StackId: 1234]";
    }
}

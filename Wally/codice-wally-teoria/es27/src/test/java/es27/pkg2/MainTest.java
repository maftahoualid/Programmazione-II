package es27.pkg2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testPopOnEmptyStackThrowsException() {
        Stack stack = new Stack();
        EmptyStackException ex = assertThrows(EmptyStackException.class, stack::pop);
        assertTrue(ex.getMessage().contains("Pop Failure"));
        assertTrue(ex.getMessage().contains("[StackId: 1234]"));
    }

    @Test
    void testPushAndPop() throws EmptyStackException {
        Stack stack = new Stack();
        stack.push("Alpha");
        stack.push("Beta");

        assertEquals("Beta", stack.pop());
        assertEquals("Alpha", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testCascadePropagationThrowsException() {
        Stack emptyStack = new Stack();
        EmptyStackException ex = assertThrows(EmptyStackException.class, () -> ExceptionGenerationDemo.gestisciRichiesta(emptyStack));
        assertTrue(ex.getMessage().contains("Pop Failure"));
    }

    @Test
    void testCascadePropagationSuccess() throws EmptyStackException {
        Stack stack = new Stack();
        stack.push("Dato Cascata");
        Object result = ExceptionGenerationDemo.gestisciRichiesta(stack);
        assertEquals("Dato Cascata", result);
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> ExceptionGenerationDemo.main(new String[]{}));
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}

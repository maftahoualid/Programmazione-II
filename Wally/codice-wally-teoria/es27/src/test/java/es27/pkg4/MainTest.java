package es27.pkg4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testFooThrowsCheckedException() {
        Dummy d = new Dummy();
        assertThrows(MyException.class, d::foo);
    }

    @Test
    void testBarWrapsInRuntimeException() {
        Dummy d = new Dummy();
        RuntimeException ex = assertThrows(RuntimeException.class, d::bar);
        assertNotNull(ex.getCause());
        assertInstanceOf(MyException.class, ex.getCause());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> DirtyTrickDemo.main(new String[]{}));
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}

package es27.pkg5;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testTryInsideLoopRecovers() {
        String[] data = { "10", "20", "ERRORE", "40" };
        List<Integer> result = LoopsAndExceptions.parseWithTryInsideLoop(data);
        // Ha saltato "ERRORE" e ha elaborato 10, 20, 40
        assertEquals(3, result.size());
        assertEquals(List.of(10, 20, 40), result);
    }

    @Test
    void testTryOutsideLoopAborts() {
        String[] data = { "10", "20", "ERRORE", "40" };
        List<Integer> result = LoopsAndExceptions.parseWithTryOutsideLoop(data);
        // Si è interrotto all'errore: solo 10 e 20
        assertEquals(2, result.size());
        assertEquals(List.of(10, 20), result);
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> LoopsAndExceptions.main(new String[]{}));
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}

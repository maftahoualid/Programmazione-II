package es27.pkg7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testRiskyOperation() {
        assertThrows(AnException.class, () -> ExceptionsAndLoops.riskyOperation("ERRORE"));
        assertThrows(AnException.class, () -> ExceptionsAndLoops.riskyOperation("FAIL"));
        assertDoesNotThrow(() -> ExceptionsAndLoops.riskyOperation("OK"));
    }

    @Test
    void testSlide27_TryInsideLoopSkipsFailedItemAndContinues() {
        List<String> input = Arrays.asList("1", "2", "ERRORE", "4", "5");
        List<String> result = ExceptionsAndLoops.processWithTryInsideLoop(input);

        // L'elemento "ERRORE" viene scartato, ma il ciclo prosegue per gli altri
        assertEquals(4, result.size());
        assertEquals(Arrays.asList("1", "2", "4", "5"), result);
    }

    @Test
    void testSlide28_TryOutsideLoopAbortsEntireLoopOnException() {
        List<String> input = Arrays.asList("1", "2", "ERRORE", "4", "5");
        List<String> result = ExceptionsAndLoops.processWithTryOutsideLoop(input);

        // Il ciclo si ferma al primo errore: "4" e "5" non vengono mai elaborati
        assertEquals(2, result.size());
        assertEquals(Arrays.asList("1", "2"), result);
    }

    @Test
    void testRetryUntilSuccess() {
        String[] attempts = { "FAIL", "ERRORE", "VALORE_VALIDO" };
        String result = ExceptionsAndLoops.retryUntilSuccess(attempts);
        assertEquals("VALORE_VALIDO", result);
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> ExceptionsAndLoops.main(new String[]{}));
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}

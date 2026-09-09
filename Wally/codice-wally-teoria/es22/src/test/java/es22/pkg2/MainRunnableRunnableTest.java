package es22.pkg2;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class MainRunnableRunnableTest {

    @Test
    void testAnonymousRunnableExecution() {
        List<Runnable> tasks = new ArrayList<>();
        AtomicBoolean executed1 = new AtomicBoolean(false);
        AtomicInteger counter = new AtomicInteger(0);

        // Passiamo un'implementazione anonima dell'interfaccia Runnable direttamente come parametro del metodo add()
        tasks.add(new Runnable() {
            @Override
            public void run() { 
                executed1.set(true);
            }
        });

        tasks.add(new Runnable() {
            @Override
            public void run() { 
                counter.addAndGet(42);
            }
        });

        assertEquals(2, tasks.size());
        assertFalse(executed1.get());
        assertEquals(0, counter.get());

        for (Runnable task : tasks) {
            task.run();
        }

        assertTrue(executed1.get());
        assertEquals(42, counter.get());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> MainRunnable.main(new String[]{}));
    }
}

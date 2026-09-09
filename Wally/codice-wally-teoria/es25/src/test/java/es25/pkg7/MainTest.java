package es25.pkg7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testProducerExtends() {
        List<StudenteLavoratore> lavoratori = new ArrayList<>();
        lavoratori.add(new StudenteLavoratore("Mario", 12345, "Meta"));
        lavoratori.add(new StudenteLavoratore("Paolo", 67890, "Amazon"));

        // Non solleva eccezioni durante la lettura
        assertDoesNotThrow(() -> Main.stampaStudenti(lavoratori));
    }

    @Test
    void testConsumerSuper() {
        List<Persona> persone = new ArrayList<>();
        persone.add(new Persona("Giovanni"));

        Main.aggiungiStudentiDiDefault(persone);

        assertEquals(3, persone.size());
        assertEquals("Giovanni", persone.get(0).getNome());
        assertInstanceOf(Studente.class, persone.get(1));
        assertEquals("Alice", persone.get(1).getNome());
        assertInstanceOf(StudenteLavoratore.class, persone.get(2));
        assertEquals("Bob", persone.get(2).getNome());
    }

    @Test
    void testPecsCopia() {
        List<StudenteLavoratore> src = new ArrayList<>();
        src.add(new StudenteLavoratore("Mario", 100, "Google"));
        src.add(new StudenteLavoratore("Luigi", 101, "Apple"));

        List<Persona> dest = new ArrayList<>();
        dest.add(new Persona("Admin"));

        Main.copia(dest, src);

        assertEquals(3, dest.size());
        assertEquals("Admin", dest.get(0).getNome());
        assertEquals("Mario", dest.get(1).getNome());
        assertEquals("Luigi", dest.get(2).getNome());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}

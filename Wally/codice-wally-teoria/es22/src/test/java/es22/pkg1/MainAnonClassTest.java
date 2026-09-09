package es22.pkg1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainAnonClassTest {

    @Test
    void testStandardPersonToString() {
        Person p = new Person("Bob");
        assertEquals("Person [name=Bob]", p.toString());
        assertEquals("Bob", p.getName());
    }

    @Test
    void testAnonymousPersonExtension() {
        // Creiamo un'istanza di una classe anonima che estende Person, assegnandola alla variabile 'sam'
        Person sam = new Person("Sam") {
            @Override
            public String toString() { 
                return "It's Sam!"; 
            }
        };

        assertEquals("It's Sam!", sam.toString());
        assertEquals("Sam", sam.getName());
        assertTrue(sam instanceof Person);
        assertNotEquals(Person.class, sam.getClass());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> MainAnonClass.main(new String[]{}));
    }
}

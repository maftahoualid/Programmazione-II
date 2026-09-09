package es26.pkg1;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MainCollectionsIterableTest {

    @Test
    void testLinkedListAndHashSetConversion() {
        Collection<Person> lista = new LinkedList<>();
        lista.add(new Person("Joe"));
        lista.add(new Person("Sam"));
        lista.add(new Person("Joe")); // Duplicato

        assertEquals(3, lista.size(), "LinkedList ammette elementi duplicati");

        Collection<Person> sett = new HashSet<>(lista);
        assertEquals(2, sett.size(), "HashSet deve eliminare automaticamente i duplicati");

        Person[] arrayP = sett.toArray(new Person[0]);
        assertEquals(2, arrayP.length);
        assertNotNull(arrayP[0]);
        assertNotNull(arrayP[1]);
    }

    @Test
    void testPersonEqualsAndHashCode() {
        Person p1 = new Person("Joe");
        Person p2 = new Person("Joe");
        Person p3 = new Person("Sam");

        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> MainCollectionsIterable.main(new String[]{}));
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}

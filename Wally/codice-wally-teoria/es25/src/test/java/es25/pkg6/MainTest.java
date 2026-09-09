package es25.pkg6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testLiskovSubstitution() {
        Student s = new Student("Sam", 123);
        Person p = s;
        assertEquals("Sam", p.getName());
        assertEquals(123, s.getMatricola());
    }

    @Test
    void testUnboundedWildcardReadObject() {
        Student s1 = new Student("Sam", 123);
        Student s2 = new Student("Paul", 456);
        Pair<Student> pairS = new Pair<>(s1, s2);

        Pair<?> pairUnbounded = pairS;
        Object first = pairUnbounded.getFirst();
        assertNotNull(first);
        assertTrue(first instanceof Student);
        assertEquals("Sam", ((Person) first).getName());
    }

    @Test
    void testUpperBoundedWildcardReadPerson() {
        Student s1 = new Student("Sam", 123);
        Student s2 = new Student("Paul", 456);
        Pair<Student> pairS = new Pair<>(s1, s2);

        Pair<? extends Person> pairExtends = pairS;
        Person first = pairExtends.getFirst();
        assertEquals("Sam", first.getName());
        assertEquals("Paul", pairExtends.getSecond().getName());
    }

    @Test
    void testPrintPairMethods() {
        Pair<Student> pairS = new Pair<>(new Student("Sam", 123), new Student("Paul", 456));
        Pair<Person> pairP = new Pair<>(new Person("Mario"), new Person("Luigi"));

        assertDoesNotThrow(() -> Main.printPairTypeParam(pairS));
        assertDoesNotThrow(() -> Main.printPairWildcard(pairS));
        assertDoesNotThrow(() -> Main.printPairTypeParam(pairP));
        assertDoesNotThrow(() -> Main.printPairWildcard(pairP));
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}

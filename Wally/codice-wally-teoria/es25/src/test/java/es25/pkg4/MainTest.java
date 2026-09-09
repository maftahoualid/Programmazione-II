package es25.pkg4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testSuperWildcardOnPair() {
        Student s = new Student("Sam", 123);

        Pair<Student> pairStudent = new Pair<>(new Student("A", 1), new Student("B", 2));
        Main.setFirstStudent(pairStudent, s);
        assertEquals(s, pairStudent.getFirst());

        Pair<Person> pairPerson = new Pair<>(new Person("P1"), new Person("P2"));
        Main.setFirstStudent(pairPerson, s);
        assertEquals(s, pairPerson.getFirst());

        Pair<Object> pairObject = new Pair<>("O1", "O2");
        Main.setFirstStudent(pairObject, s);
        assertEquals(s, pairObject.getFirst());
    }

    @Test
    void testSuperWildcardOnList() {
        Student s = new Student("Sam", 123);
        List<Person> personList = new ArrayList<>();
        Main.addStudent(personList, s);
        assertEquals(1, personList.size());
        assertEquals(s, personList.get(0));
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}

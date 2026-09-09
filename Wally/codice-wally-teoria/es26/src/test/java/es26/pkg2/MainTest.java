package es26.pkg2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testPersonComparable() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Sam"));
        people.add(new Person("Alice"));
        people.add(new Person("Bob"));

        Collections.sort(people);

        assertEquals("Alice", people.get(0).getName());
        assertEquals("Bob", people.get(1).getName());
        assertEquals("Sam", people.get(2).getName());
    }

    @Test
    void testStudentInheritedComparable() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Sam", 103));
        students.add(new Student("Alice", 101));
        students.add(new Student("Bob", 102));

        // Ordina secondo l'ordinamento naturale di Person (alfabetico per nome)
        Collections.sort(students);

        assertEquals("Alice", students.get(0).getName());
        assertEquals("Bob", students.get(1).getName());
        assertEquals("Sam", students.get(2).getName());
    }

    @Test
    void testStudentComparatorClass() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Zeno", 300));
        students.add(new Student("Anna", 100));
        students.add(new Student("Mario", 200));

        Collections.sort(students, new StudentMatricolaComparator());

        assertEquals(100, students.get(0).getMatricola());
        assertEquals(200, students.get(1).getMatricola());
        assertEquals(300, students.get(2).getMatricola());
    }

    @Test
    void testStudentComparatorAnonClass() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Zeno", 300));
        students.add(new Student("Anna", 100));
        students.add(new Student("Mario", 200));

        Comparator<Student> desc = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getMatricola(), s1.getMatricola());
            }
        };
        Collections.sort(students, desc);

        assertEquals(300, students.get(0).getMatricola());
        assertEquals(200, students.get(1).getMatricola());
        assertEquals(100, students.get(2).getMatricola());
    }

    @Test
    void testStudentComparatorLambda() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Zeno", 300));
        students.add(new Student("Anna", 100));
        students.add(new Student("Mario", 200));

        Collections.sort(students, (s1, s2) -> Integer.compare(s1.getMatricola(), s2.getMatricola()));

        assertEquals(100, students.get(0).getMatricola());
        assertEquals(200, students.get(1).getMatricola());
        assertEquals(300, students.get(2).getMatricola());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}

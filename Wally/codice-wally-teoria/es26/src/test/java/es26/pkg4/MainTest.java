package es26.pkg4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testSortDedicatedClass() {
        Student[] studenti = {
            new Student("Zeno", 300),
            new Student("Anna", 100),
            new Student("Mario", 200)
        };
        Arrays.sort(studenti, new StudentMatricolaComparator());
        assertEquals(100, studenti[0].getMatricola());
        assertEquals(200, studenti[1].getMatricola());
        assertEquals(300, studenti[2].getMatricola());
    }

    @Test
    void testSortAnonymousClass() {
        Student[] studenti = {
            new Student("Zeno", 300),
            new Student("Anna", 100),
            new Student("Mario", 200)
        };
        Arrays.sort(studenti, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getMatricola(), s1.getMatricola());
            }
        });
        assertEquals(300, studenti[0].getMatricola());
        assertEquals(200, studenti[1].getMatricola());
        assertEquals(100, studenti[2].getMatricola());
    }

    @Test
    void testSortLambda() {
        Student[] studenti = {
            new Student("Zeno", 300),
            new Student("Anna", 100),
            new Student("Mario", 200)
        };
        Arrays.sort(studenti, (s1, s2) -> Integer.compare(s1.getMatricola(), s2.getMatricola()));
        assertEquals(100, studenti[0].getMatricola());
        assertEquals(200, studenti[1].getMatricola());
        assertEquals(300, studenti[2].getMatricola());
    }

    @Test
    void testSortWithSuperComparator() {
        Student[] studenti = {
            new Student("Zeno", 300),
            new Student("Anna", 100),
            new Student("Mario", 200)
        };
        Comparator<Person> cmpPerson = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Arrays.sort(studenti, cmpPerson);
        assertEquals("Anna", studenti[0].getName());
        assertEquals("Mario", studenti[1].getName());
        assertEquals("Zeno", studenti[2].getName());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}

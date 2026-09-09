package es24.pkg2;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainClassRoomTest {

    @Test
    void testComparableStudent() {
        Student s1 = new Student("Paul", 123);
        Student s2 = new Student("Sam", 456);

        assertTrue(s1.compareTo(s2) < 0);
        assertTrue(s2.compareTo(s1) > 0);
        assertEquals(0, s1.compareTo(new Student("Paul", 123)));
    }

    @Test
    void testClassRoomIteratorGenerics() {
        Student[] arr = { new Student("Sam", 456), new Student("Paul", 123) };
        ClassRoom classRoom = new ClassRoom(arr);

        List<Student> collected = new ArrayList<>();
        // Test enhanced for-each (Iterable<Student>) senza cast
        for (Student s : classRoom) {
            collected.add(s);
        }

        assertEquals(2, collected.size());
        assertEquals("Sam", collected.get(0).getName());
        assertEquals(456, collected.get(0).getMatricola());
        assertEquals("Paul", collected.get(1).getName());
        assertEquals(123, collected.get(1).getMatricola());

        // Test manual Iterator<Student>
        Iterator<Student> it = classRoom.iterator();
        assertTrue(it.hasNext());
        Student next1 = it.next();
        assertEquals("Sam", next1.getName());
        assertTrue(it.hasNext());
        Student next2 = it.next();
        assertEquals("Paul", next2.getName());
        assertFalse(it.hasNext());
    }

    @Test
    void testForEachAndComparatorLambda() {
        Student[] arr = { new Student("Sam", 456), new Student("Paul", 123) };
        ClassRoom classRoom = new ClassRoom(arr);

        // Test forEach con lambda classica
        List<String> names = new ArrayList<>();
        classRoom.forEach(s -> names.add(s.getName()));
        assertEquals(List.of("Sam", "Paul"), names);

        // Test Comparator con lambda classica
        Arrays.sort(arr, (a, b) -> a.getMatricola() - b.getMatricola());
        assertEquals("Paul", arr[0].getName());
        assertEquals("Sam", arr[1].getName());
    }

    @Test
    void testMainExecution() {
        assertDoesNotThrow(() -> MainClassRoom.main(new String[]{}));
    }
}

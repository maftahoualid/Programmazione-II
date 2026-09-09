package es24.pkg2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MainClassRoom {
    public static void main(String[] args) {
        // Creazione array di studenti
        Student s1 = new Student("Sam", 456);
        Student s2 = new Student("Paul", 123);
        Student[] arrS = { s1, s2 };

        // 1. Ordinamento con Comparable<Student>
        System.out.println("Prima:  " + Arrays.toString(arrS));
        Arrays.sort(arrS);
        System.out.println("Dopo: "+ Arrays.toString(arrS));

        // 2. Ordinamento con Lambda su Comparator<Student>
        Arrays.sort(arrS, (a, b) -> b.getMatricola() - a.getMatricola());
        System.out.println("Dopo: " + Arrays.toString(arrS));

        // 3. Iterazione con ClassRoom Iterable<Student> (enhanced for-each)
        ClassRoom classRoom = new ClassRoom(arrS);
        for (Student student : classRoom) { System.out.println(student.toString()); }

        // 4. Iterazione con Iterator<Student>
        Iterator<Student> it = classRoom.iterator();
        while (it.hasNext()) {
            Student student = it.next();
            System.out.println("Studente: " + student.getName() + " (" + student.getMatricola() + ")");
        }

        // 5. Iterazione con Lambda tramite forEach
        classRoom.forEach(student -> System.out.println(student));

    }
}

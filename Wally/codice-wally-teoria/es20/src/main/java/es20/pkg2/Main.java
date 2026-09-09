package es20.pkg2;

import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        // 1.2 Sottoclasse Student
        Student s1 = new Student("Samuele", 1001);

        ComparableStudent cs1 = new ComparableStudent("Alice", 200);
        ComparableStudent cs2 = new ComparableStudent("Alice", 200);
        ComparableStudent cs3 = new ComparableStudent("Bob", 150);
        ComparableStudent cs4 = new ComparableStudent("Charlie", 350);
        ComparableStudent cs5 = new ComparableStudent("Alice", 250); // Stesso nome, diversa matricola

        ComparableStudent[] studentsArray = { cs4, cs1, cs3, cs5 };

        for (ComparableStudent cs : studentsArray) { System.out.println(" - " + cs.name + " (" + cs.matricola + ")"); }

        Arrays.sort(studentsArray);

        for (ComparableStudent cs : studentsArray) { System.out.println(" - " + cs.name + " (" + cs.matricola + ")"); }

        Student[] aulaArray = {
            new Student("Sam", 101),
            new Student("Paul", 102),
            new Student("Anna", 103)
        };
        ClassRoom classroom = new ClassRoom(aulaArray);

        // ClassRoom implementa l'interfaccia raw Iterable, 
        // quindi l'elemento estratto dal for-each è Object
        for (Object obj : classroom) {
            Student s = (Student) obj; // Downcast esplicito da Object a Student
            System.out.println(" - Studente: " + s);
        }

        // 3.2 Iterazione manuale tramite l'Iterator (classe anonima)
        Iterator it = classroom.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println(s.getName() + " [matricola: " + s.getMatricola() + "]");
        }
    }
}

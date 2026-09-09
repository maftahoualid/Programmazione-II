package es26.pkg2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== es26.pkg2: Ordinamento con Comparable e Comparator ===");

        // =========================================================================
        // 1. Person implements Comparable<Person> -> Ordinamento Naturale
        // =========================================================================
        System.out.println("\n--- 1. Ordinamento di List<Person> con Comparable<Person> ---");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Sam"));
        personList.add(new Person("Alice"));
        personList.add(new Person("Bob"));

        System.out.println("Prima del sort: " + personList);
        // Collections.sort usa compareTo() di Person (ordine alfabetico per nome)
        Collections.sort(personList);
        System.out.println("Dopo Collections.sort(personList): " + personList);

        // =========================================================================
        // 2. Student extends Person (eredita Comparable<Person>, NON Comparable<Student>)
        // =========================================================================
        System.out.println("\n--- 2. Ordinamento di List<Student> con Comparable<? super Student> ---");
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Sam", 103));
        studentList.add(new Student("Alice", 101));
        studentList.add(new Student("Bob", 102));

        System.out.println("Prima del sort: " + studentList);

        /*
         * PERCHÉ QUESTO COMPILA?
         *
         * La firma di Collections.sort è:
         *   public static <T extends Comparable<? super T>> void sort(List<T> list)
         *
         * Qui T = Student.
         * Student non implementa Comparable<Student>, ma eredita Comparable<Person> da Person.
         * Dato che Person è una superclasse di Student, Person soddisfa <? super Student>!
         * Se la firma fosse stata <T extends Comparable<T>>, questo NON avrebbe compilato!
         * Quindi la lista viene ordinata secondo il compareTo() ereditato da Person (alfabetico per nome).
         */
        Collections.sort(studentList);
        System.out.println("Dopo Collections.sort(studentList) [ordine naturale ereditato da Person]: " + studentList);

        // =========================================================================
        // 3. Ordinamento di Student con Comparator in 3 MODI DIVERSI (per matricola)
        // =========================================================================
        System.out.println("\n--- 3. Ordinamento di Student con Comparator (3 modi per matricola) ---");

        // Prepariamo una lista disordinata per matricola
        List<Student> listPerMatricola = new ArrayList<>();
        listPerMatricola.add(new Student("Zeno", 300));
        listPerMatricola.add(new Student("Anna", 100));
        listPerMatricola.add(new Student("Mario", 200));

        System.out.println("Lista prima dell'ordinamento per matricola: " + listPerMatricola);

        // ---------------------------------------------------------------------
        // MODO 1: Classe Dedicata (StudentMatricolaComparator)
        // ---------------------------------------------------------------------
        Collections.sort(listPerMatricola, new StudentMatricolaComparator());
        System.out.println("Modo 1 [Classe Dedicata - Matricola crescente]: " + listPerMatricola);

        // ---------------------------------------------------------------------
        // MODO 2: Classe Anonima (new Comparator<Student>() { ... })
        // ---------------------------------------------------------------------
        // Ordiniamo in ordine decrescente di matricola usando una classe anonima

        /* Comparator<Student> anonComparatorDesc = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getMatricola(), s1.getMatricola()); // Decrescente
            }
        };
        Collections.sort(listPerMatricola, anonComparatorDesc); */ // o in modo più compatto:

        Collections.sort(listPerMatricola, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getMatricola(), s1.getMatricola()); // Decrescente
            }
        });
        System.out.println("Modo 2 [Classe Anonima - Matricola decrescente]: " + listPerMatricola);

        // ---------------------------------------------------------------------
        // MODO 3: Espressione Lambda ((s1, s2) -> ...)
        // ---------------------------------------------------------------------
        // Riordiniamo in ordine crescente di matricola con una sintetica espressione lambda
        Comparator<Student> lambdaComparatorAsc = (s1, s2) -> Integer.compare(s1.getMatricola(), s2.getMatricola());
        Collections.sort(listPerMatricola, lambdaComparatorAsc);
        System.out.println("Modo 3 [Espressione Lambda - Matricola crescente]: " + listPerMatricola);

        // Oppure direttamente inline con lambda (decrescente):
        Collections.sort(listPerMatricola, (s1, s2) -> Integer.compare(s2.getMatricola(), s1.getMatricola()));
        System.out.println("Modo 3 bis [Lambda inline - Matricola decrescente]: " + listPerMatricola);
    }
}

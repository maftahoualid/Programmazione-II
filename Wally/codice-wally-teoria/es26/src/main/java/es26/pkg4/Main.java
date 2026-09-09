package es26.pkg4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * es26.pkg4: Ordinamento di Array con Comparator
 *
 * Firma del metodo esaminato:
 *   public static <T> void sort(T[] arr, Comparator<? super T> cmp)
 *
 * CARATTERISTICHE (Slide T16):
 * - È MORE TYPE-SAFE rispetto a Arrays.sort(Object[]): il compilatore verifica
 *   a compile-time che il Comparator sia compatibile con il tipo T degli elementi.
 * - Wildcard covariante (? super T): accetta un comparatore per T o per una sua superclasse
 *   (es. un Comparator<Person> può ordinare un array Student[]).
 * - Permette di definire criteri di ordinamento arbitrari senza richiedere che T
 *   implementi Comparable.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== es26.pkg4: Arrays.sort(T[], Comparator<? super T>) Type-Safe ===");

        Student[] studenti = {
            new Student("Zeno", 300),
            new Student("Anna", 100),
            new Student("Mario", 200)
        };

        System.out.println("\nArray originale di partenza:");
        System.out.println(Arrays.toString(studenti));

        // =========================================================================
        // MODO 1: Classe Dedicata (StudentMatricolaComparator)
        // =========================================================================
        System.out.println("\n--- Modo 1: Classe Dedicata (Matricola crescente) ---");
        Arrays.sort(studenti, new StudentMatricolaComparator());
        System.out.println(Arrays.toString(studenti));

        // =========================================================================
        // MODO 2: Classe Anonima (new Comparator<Student>() { ... })
        // =========================================================================
        System.out.println("\n--- Modo 2: Classe Anonima (Matricola decrescente) ---");
        Arrays.sort(studenti, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getMatricola(), s1.getMatricola()); // Ordine inverso
            }
        });
        System.out.println(Arrays.toString(studenti));

        // =========================================================================
        // MODO 3: Espressione Lambda ((s1, s2) -> ...)
        // =========================================================================
        System.out.println("\n--- Modo 3: Espressione Lambda (Matricola crescente) ---");
        Comparator<Student> lambdaCrescente = (s1, s2) -> Integer.compare(s1.getMatricola(), s2.getMatricola());
        Arrays.sort(studenti, lambdaCrescente);
        System.out.println(Arrays.toString(studenti));

        // Modo 3 bis: Lambda inline diretta (Matricola decrescente)
        System.out.println("\n--- Modo 3 bis: Lambda inline diretta (Matricola decrescente) ---");
        Arrays.sort(studenti, (s1, s2) -> Integer.compare(s2.getMatricola(), s1.getMatricola()));
        System.out.println(Arrays.toString(studenti));

        // =========================================================================
        // BONUS WILDCARD PECS: Comparator<? super T> (Uso di Comparator<Person> su Student[])
        // =========================================================================
        System.out.println("\n--- Bonus PECS: Comparator<Person> usato su Student[] (per nome) ---");
        // Comparator definito sul supertipo Person: confronta per nome
        Comparator<Person> cmpPersonPerNome = (p1, p2) -> p1.getName().compareTo(p2.getName());
        // Grazie a Comparator<? super Student>, possiamo passarlo direttamente ad Arrays.sort(studenti, ...)
        Arrays.sort(studenti, cmpPersonPerNome);
        System.out.println("Studenti ordinati per nome tramite Comparator<Person>: " + Arrays.toString(studenti));
    }
}

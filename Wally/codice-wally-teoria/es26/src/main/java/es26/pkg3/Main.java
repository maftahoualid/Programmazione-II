package es26.pkg3;

import java.util.Arrays;

/**
 * es26.pkg3: Ordinamento di Array con Ordinamento Naturale
 *
 * Firma del metodo esaminato:
 *   public static void sort(Object[] arr)
 *
 * CARATTERISTICHE (Slide T16):
 * - Effettua l'ordinamento basandosi sull'ordine naturale: confronta gli elementi
 *   invocando il loro metodo compareTo() dopo aver eseguito un cast a runtime a Comparable.
 * - Non è type-safe a tempo di compilazione: il parametro Object[] accetta QUALSIASI
 *   array di oggetti (anche classi che non implementano Comparable).
 * - Se gli elementi non implementano Comparable, a runtime viene sollevata ClassCastException!
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== es26.pkg3: Arrays.sort(Object[] arr) con Ordinamento Naturale ===");

        // =========================================================================
        // 1. Array di tipi standard (String, Integer) che implementano Comparable
        // =========================================================================
        System.out.println("\n--- 1. Ordinamento di String[] e Integer[] ---");
        String[] nomi = { "Zeno", "Anna", "Mario", "Bob" };
        System.out.println("String[] prima del sort: " + Arrays.toString(nomi));
        Arrays.sort(nomi);
        System.out.println("String[] dopo il sort:  " + Arrays.toString(nomi));

        Integer[] numeri = { 42, 10, 88, 5, 23 };
        System.out.println("Integer[] prima del sort: " + Arrays.toString(numeri));
        Arrays.sort(numeri);
        System.out.println("Integer[] dopo il sort:  " + Arrays.toString(numeri));

        // =========================================================================
        // 2. Array di oggetti di una classe personalizzata (Person implements Comparable<Person>)
        // =========================================================================
        System.out.println("\n--- 2. Ordinamento di Person[] (implements Comparable<Person>) ---");
        Person[] persone = {
            new Person("Sam"),
            new Person("Alice"),
            new Person("Bob")
        };
        System.out.println("Person[] prima del sort: " + Arrays.toString(persone));
        // Invoca compareTo() definito in Person (alfabetico per nome)
        Arrays.sort(persone);
        System.out.println("Person[] dopo il sort:  " + Arrays.toString(persone));

        // =========================================================================
        // 3. Trappola a Runtime: Array di oggetti che NON implementano Comparable
        // =========================================================================
        System.out.println("\n--- 3. Trappola a Runtime con classe non-Comparable (Cane[]) ---");
        Cane[] cani = {
            new Cane("Fido"),
            new Cane("Bobby"),
            new Cane("Rex")
        };
        System.out.println("Cane[] prima del tentativo di sort: " + Arrays.toString(cani));

        // Il codice seguente COMPILA PERFETTAMENTE perché Cane[] è compatibile con Object[]!
        // A RUNTIME però genera ClassCastException. Lo gestiamo con try-catch a scopo didattico:
        try {
            Arrays.sort(cani); // Lancia java.lang.ClassCastException
        } catch (ClassCastException e) {
            System.out.println("Eccezione intercettata a runtime: " + e.getMessage());
            System.out.println("// MOTIVO: Cane non implementa Comparable, e Arrays.sort(Object[])");
            System.out.println("// non ha vincoli parametrici a tempo di compilazione.");
        }
    }
}

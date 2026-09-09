package es25.pkg3;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== es25.pkg3: Multiple Bounds <T extends Person & Comparable<T>> ===");

        Student s1 = new Student("Sam", 456);
        Student s2 = new Student("Paul", 123);

        // Student soddisfa ENTRAMBI i bound:
        // 1. estende Person
        // 2. implementa Comparable<Student>
        Pair<Student> studentPair = new Pair<>(s1, s2);

        System.out.println("Primo studente: " + studentPair.getFirst());
        System.out.println("Secondo studente: " + studentPair.getSecond());

        // Metodo dal 1° tipo (Person):
        System.out.println("Nome primo studente (da Person.getName()): " + studentPair.getFirstName());

        // Metodi dal 2° tipo (Comparable<T>):
        System.out.println("Studente con matricola maggiore (da Comparable.compareTo()): " + studentPair.getMax());
        System.out.println("Studente con matricola minore (da Comparable.compareTo()): " + studentPair.getMin());

        // ERRORE DI COMPILAZIONE: Person non implementa Comparable<Person>!
        // Pair<Person> p = new Pair<>(new Person("A"), new Person("B"));
        // -> Person is not within bounds of type-variable T (requires Comparable<T>)
    }
}

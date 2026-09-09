package es25.pkg2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== es25.pkg2: Pair<T extends Person> Bounded (Slide 16-17 T15) ===");

        Pair<Person> pair = new Pair<>(new Person("Alice"), new Person("Bob"));
        System.out.println("getFirst(): " + pair.getFirst());
        System.out.println("getSecond(): " + pair.getSecond());

        // Chiamata ai metodi di Pair che invocano internamente first.getName() e second.getName()
        System.out.println("getFirstName() (da first.getName()): " + pair.getFirstName());
        System.out.println("getSecondName() (da second.getName()): " + pair.getSecondName());

        // ERRORE DI COMPILAZIONE SE IL TIPO NON ESTENDE PERSON:
        // Pair<Integer> invalid = new Pair<>(1, 2);
        // -> type argument Integer is not within bounds of type-variable T
    }
}

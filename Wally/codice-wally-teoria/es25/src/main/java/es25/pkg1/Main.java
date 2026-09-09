package es25.pkg1;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== es25.pkg1: Pair<T> Unbounded (Slide 15 T15) ===");

        Pair<Person> personPair = new Pair<>(new Person("Alice"), new Person("Bob"));
        System.out.println("getFirst(): " + personPair.getFirst());
        System.out.println("getSecond(): " + personPair.getSecond());

        // Poiché il tipo di ritorno di getFirst() è Person a runtime, dall'esterno possiamo chiamare getName()
        System.out.println("personPair.getFirst().getName(): " + personPair.getFirst().getName());

        // Ma internamente a Pair<T>, T è unbounded: first.getName() non compila
        // perché Pair può essere istanziata con QUALSIASI tipo:
        Pair<Integer> intPair = new Pair<>(10, 20);
        System.out.println("Pair con Integer: " + intPair.getFirst() + ", " + intPair.getSecond());
    }
}

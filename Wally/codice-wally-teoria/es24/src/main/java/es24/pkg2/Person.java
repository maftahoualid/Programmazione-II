package es24.pkg2;

/**
 * Superclasse base Person (Slide T15 slide 11-13).
 */
public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

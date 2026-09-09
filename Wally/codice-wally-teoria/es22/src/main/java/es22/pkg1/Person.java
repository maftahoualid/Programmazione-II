package es22.pkg1;

/**
 * Slide 13-16 (T14 - Nested and Anonymous Classes)
 * Superclasse base Person.
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
        return "Person [name=" + name + "]";
    }
}

package es20.pkg2;

/**
 * Slide 34-37 (T12 - Inheritance and Polymorphism)
 * Superclasse base Person.
 */
public class Person {
    String name;

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

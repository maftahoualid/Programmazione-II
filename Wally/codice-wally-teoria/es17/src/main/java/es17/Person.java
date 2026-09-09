package es17;

public class Person {
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    // Posso decidere di non permettere
    // l'override di un metodo usando final
    public final String getName() {
        return name;
    }
}

package es26.pkg2;

import java.util.Objects;

/**
 * Person implementa Comparable<Person>.
 * L'ordinamento naturale predefinito è alfabetico per nome.
 */
public class Person implements Comparable<Person> {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person other) {
        // Ordinamento naturale: alfabetico per nome
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Person(" + name + ")";
    }
}

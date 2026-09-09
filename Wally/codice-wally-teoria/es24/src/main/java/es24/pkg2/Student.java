package es24.pkg2;

/**
 * Student con Generics (Slide T15 slide 11).
 * Implementa l'interfaccia generica Comparable<Student>.
 */
public class Student extends Person implements Comparable<Student> {
    private final int matricola;

    public Student(String name, int matricola) {
        super(name);
        this.matricola = matricola;
    }

    // Costruttore di copia: per new Student(students[next++]) in CRIterator
    public Student(Student other) {
        super(other.getName());
        this.matricola = other.matricola;
    }

    public int getMatricola() {
        return matricola;
    }

    @Override
    public int compareTo(Student other) { // simpler and safer code grazie ai generics
        return this.matricola - other.matricola;
    }

    @Override
    public String toString() {
        return getName() + " " + matricola;
    }
}

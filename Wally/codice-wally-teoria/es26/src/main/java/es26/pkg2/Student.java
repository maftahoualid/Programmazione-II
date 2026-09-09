package es26.pkg2;

/**
 * Student estende Person.
 *
 * REGOLA FONDAMENTALE DI JAVA SUI GENERICS (Slide 26 T16):
 * Student eredita l'implementazione di Comparable<Person> da Person.
 *
 * In Java NON è consentito scrivere:
 *   public class Student extends Person implements Comparable<Student>
 * Perché la stessa interfaccia generica Comparable non può essere implementata
 * due volte con argomenti di tipo diversi (Comparable<Person> e Comparable<Student>).
 *
 * Quindi Student possiede SOLO l'ordinamento naturale basato su Person (per nome).
 */
public class Student extends Person {
    private final int matricola;

    public Student(String name, int matricola) {
        super(name);
        this.matricola = matricola;
    }

    public int getMatricola() {
        return matricola;
    }

    @Override
    public String toString() {
        return "Student(" + getName() + ", matr. " + matricola + ")";
    }
}

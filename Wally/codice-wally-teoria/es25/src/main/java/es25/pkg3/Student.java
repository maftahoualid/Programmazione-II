package es25.pkg3;

public class Student extends Person implements Comparable<Student> {
    private final int matricola;

    public Student(String name, int matricola) {
        super(name);
        this.matricola = matricola;
    }

    public int getMatricola() {
        return matricola;
    }

    @Override
    public int compareTo(Student other) {
        return this.matricola - other.matricola;
    }

    @Override
    public String toString() {
        return getName() + " [matr. " + matricola + "]";
    }
}

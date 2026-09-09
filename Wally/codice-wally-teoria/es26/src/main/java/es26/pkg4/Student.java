package es26.pkg4;

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

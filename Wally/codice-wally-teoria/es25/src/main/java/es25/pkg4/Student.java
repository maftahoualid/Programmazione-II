package es25.pkg4;

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
        return getName() + " [matr. " + matricola + "]";
    }
}

package es18;

public class Student extends Person {
    int matricola;

    public Student(String name, int matricola) {
        super(name);
        this.matricola = matricola;
    }

    public int getMatricola() {
        return matricola;
    }

    @Override
    public String toString() {
        return "Student [name=" + getName() + ", matricola=" + matricola + "]";
    }
}

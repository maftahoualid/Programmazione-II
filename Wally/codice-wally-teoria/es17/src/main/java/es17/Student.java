package es17;

public class Student extends Person {
    int matricola;

    public Student(String name, int matricola) {
        super(name);
        this.matricola = matricola;
    }

    // Non posso fare l'override perché getName è final in Person
    // @Override
    // public String getName() { return "Studente: " + name; }
}

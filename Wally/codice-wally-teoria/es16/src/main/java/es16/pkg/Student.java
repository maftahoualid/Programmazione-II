package es16.pkg;

public class Student extends es16.Person {
    private int matricola;

    public Student(String name, int matricola) {
        super(name);
        this.matricola = matricola;
    }

    // non posso accedere all'attributo name se non lo rendo public o protected
    // public void print() { System.out.println("Nome: " + this.name); }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }
}

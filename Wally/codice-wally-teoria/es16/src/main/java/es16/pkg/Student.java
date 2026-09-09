package es16.pkg;

public class Student extends es16.Person {
    private int matricola;

    public Student() { // costruttore default
        // se dichiaro un costruttore nella classe padre
        // questo costruttore non verrà creato in automatico
        // quindi devo chiamarlo esplicitamente
        super(); // chiamata al costruttore default della superclasse
    }

    public Student(String name, int matricola) {
        // super chiama il costruttore che corrisponde
        // alla firma (il tipo e numero di argomenti)
        super(name); // qui non chiama il default ma il parametrico
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

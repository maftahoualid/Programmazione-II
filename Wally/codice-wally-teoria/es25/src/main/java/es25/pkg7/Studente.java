package es25.pkg7;

public class Studente extends Persona {
    private final int matricola;

    public Studente(String nome, int matricola) {
        super(nome);
        this.matricola = matricola;
    }

    public int getMatricola() {
        return matricola;
    }

    @Override
    public String toString() {
        return "Studente(" + getNome() + ", matr. " + matricola + ")";
    }
}

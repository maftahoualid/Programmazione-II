package es25.pkg7;

public class StudenteLavoratore extends Studente {
    private final String azienda;

    public StudenteLavoratore(String nome, int matricola, String azienda) {
        super(nome, matricola);
        this.azienda = azienda;
    }

    public String getAzienda() {
        return azienda;
    }

    @Override
    public String toString() {
        return "StudenteLavoratore(" + getNome() + ", matr. " + getMatricola() + ", az. " + azienda + ")";
    }
}

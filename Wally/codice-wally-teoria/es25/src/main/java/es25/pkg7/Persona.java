package es25.pkg7;

public class Persona {
    private final String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Persona(" + nome + ")";
    }
}

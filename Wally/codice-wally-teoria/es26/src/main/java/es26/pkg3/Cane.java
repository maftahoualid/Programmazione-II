package es26.pkg3;

/**
 * Classe Cane che NON implementa Comparable.
 * Serve per dimostrare il comportamento a runtime di Arrays.sort(Object[]):
 * il compilatore non segnala errori (Object[] accetta qualsiasi array di oggetti),
 * ma a runtime viene lanciata una ClassCastException.
 */
public class Cane {
    private final String nome;

    public Cane(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cane(" + nome + ")";
    }
}

package es10;
public class SingletonPattern {
    private static SingletonPattern instance; // VARIABILE STATICA ISTANZA (A NULL)

    private SingletonPattern() { } // COSTRUTTORE PRIVATO (NON POSSO CREARE OGGETTI DA FUORI)

    public static SingletonPattern getInstance() { // METODO STATICO PER OTTENERE UNA ISTANZA
        // SE NON CI SONO ISTANZE, CREANE UNA, ALTRIMENTI, DAMMI QUELLA ESISTENTE
        if(instance==null) { instance = new SingletonPattern(); }
        return instance;
    }

}

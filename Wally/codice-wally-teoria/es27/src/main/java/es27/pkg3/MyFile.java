package es27.pkg3;

public class MyFile {
    private final String name;
    private boolean shouldFailOpen = true;

    public MyFile(String name) {
        this.name = name;
    }

    public MyFile(String name, boolean shouldFailOpen) {
        this.name = name;
        this.shouldFailOpen = shouldFailOpen;
    }

    // I METODI CHE POSSONO LANCIARE UNA ECCEZIONE CHECKED DEVONO DICHIARARE throws NomeEccezione
    public void open() throws FileError {
        if (shouldFailOpen) {
            // Simuliamo un errore di apertura (es. file non trovato)
            throw new FileError("Impossibile aprire il file: " + name);
        }
        System.out.println("File '" + name + "' aperto con successo.");
    }
    public void read() throws IOError {
        System.out.println("Lettura del file '" + name + "' in corso...");
    }

    public void close() {
        System.out.println("File '" + name + "' chiuso regolarmente.");
    }
}

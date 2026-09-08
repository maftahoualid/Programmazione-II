package es09;
public class Memoria {
    // VARIABILI DI ISTANZA (CAMPI DELLA CLASSE)
    // (una copia per ogni oggetto, implicitamente inizializzate)
    int i; // HEAP : creo oggetto int a 0 nello heap (e ci faccio puntare i)
    String s1 = "Testo"; // HEAP : creo oggetto String nello Heap (e ci faccio puntare s1)
    String s2 = new String("Testo"); // HEAP : creo oggetto String nello Heap (e ci faccio puntare s2)

    // VARIABILI STATICHE
    // (condivise da tutte le istanze e accedute contemporaneamente da più oggetti)
    // (inizializzate )
    static String s4 = "Testo"; // STATIC : creo oggetto String nella memoria statica (e ci faccio puntare s4)
    final String s5 = "Testo"; // STATIC : creo oggetto String nella memoria statica (e ci faccio puntare s5)

    static int[] arr1 = { 1, 2, 3 }; // STATIC

    static int[] arr2; // STATIC
    static {
        arr2 = new int[3];
        arr2[0] = 1;
        arr2[1] = 2;
        arr2[2] = 3;
    }; // STATIC

    void metodo() {

        // VARIABILI LOCALI
        // (una copia per ogni oggetto e per ogni chiamata a funzione/blocco di codice)
        int j; // STACK : creo int a 0 nello stack della chiamata (e ci faccio puntare j)

        // CASI PARTICOLARI
        String s3 = new String("Testo"); // HEAP : con new, l'oggetto viene creato nello Heap
        s4 = s3; // HEAP : faccio puntare s4 (ex var statica) a un oggetto nello Heap
    } // QUI FINISCE LO SCOPE DELLE VARIABILI LOCALI (le variabili sono distrutte dopo
      // questa chiamata)

}

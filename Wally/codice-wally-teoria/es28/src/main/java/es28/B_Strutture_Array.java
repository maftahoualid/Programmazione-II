package es28;

import java.util.Arrays;

/*
 * ============================================================
 *  B — ARRAY  []
 * ============================================================
 *
 *  - Dimensione FISSA definita alla creazione (non può cambiare).
 *  - Possono contenere tipi primitivi (int, double…) o oggetti.
 *  - Indicizzati da 0 a length-1.
 *  - Accesso O(1), inserimento/rimozione NON supportati nativamente.
 *
 *  Tipi di array:
 *  • Primitivi:  int[], double[], char[], boolean[], long[], byte[], short[], float[]
 *  • Oggetti:    String[], Integer[], Object[]  (supportano null)
 *  • Multi-dim:  int[][], String[][]
 * ============================================================
 */
public class B_Strutture_Array {

    public static void demo() {

        // ── A. DICHIARAZIONE E INIZIALIZZAZIONE ───────────────

        // A1. Vuoto con dimensione fissa — valori di default:
        //     int/long/byte/short/float/double → 0 / 0L / 0.0
        //     boolean → false
        //     Object  → null
        int[]    arrayIntVuoto    = new int[5];        // [0, 0, 0, 0, 0]
        String[] arrayStrVuoto    = new String[3];     // [null, null, null]
        System.out.println(Arrays.toString(arrayIntVuoto));   // [0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(arrayStrVuoto));   // [null, null, null]

        // A2. Inizializzazione inline (dimensione calcolata automaticamente)
        int[]    valori  = {1, 2, 3, 4, 5};
        String[] parole  = {"alpha", "beta", "gamma"};
        double[] prezzi  = {1.5, 2.3, 9.99};

        // A3. Sintassi esplicita con new (utile per passarlo direttamente a un metodo)
        String[] parole2 = new String[]{"A", "B", "C"};


        // ── B. ACCESSO E MODIFICA ─────────────────────────────
        System.out.println(valori[0]);   // 1   (primo elemento)
        System.out.println(valori[4]);   // 5   (ultimo elemento)
        System.out.println(valori.length); // 5

        valori[2] = 99;
        System.out.println(Arrays.toString(valori));  // [1, 2, 99, 4, 5]


        // ── C. ITERAZIONE ────────────────────────────────────
        // C1. for classico
        for (int i = 0; i < parole.length; i++) {
            System.out.print(parole[i] + " ");
        }
        System.out.println();

        // C2. for-each (non hai l'indice, non puoi modificare)
        for (String p : parole) {
            System.out.print(p.toUpperCase() + " ");
        }
        System.out.println();


        // ── D. ARRAY MULTIDIMENSIONALE ────────────────────────
        int[][] matrice = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(matrice[1][2]);  // 6  (riga 1, colonna 2)
        System.out.println(Arrays.deepToString(matrice));
        // [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

        // Array "jagged" (righe di lunghezza diversa)
        int[][] jagged = new int[3][];
        jagged[0] = new int[]{1};
        jagged[1] = new int[]{2, 3};
        jagged[2] = new int[]{4, 5, 6};
        System.out.println(Arrays.deepToString(jagged)); // [[1], [2, 3], [4, 5, 6]]


        // ── E. METODI UTILI DI Arrays ─────────────────────────
        // (vedi anche N_ClassiUtility.java per un approfondimento)
        int[] numeri = {5, 3, 1, 4, 2};

        // sort — ordina in-place
        Arrays.sort(numeri);
        System.out.println(Arrays.toString(numeri));  // [1, 2, 3, 4, 5]

        // binarySearch — funziona SOLO su array già ordinati, O(log n)
        int idx = Arrays.binarySearch(numeri, 3);
        System.out.println(idx);  // 2

        // copyOf — copia (con troncatura o padding se newLen diversa)
        int[] copia = Arrays.copyOf(numeri, 3);
        System.out.println(Arrays.toString(copia));  // [1, 2, 3]

        // copyOfRange — copia un intervallo [from, to)
        int[] sub = Arrays.copyOfRange(numeri, 1, 4);
        System.out.println(Arrays.toString(sub));  // [2, 3, 4]

        // fill — riempie tutto l'array con un valore
        Arrays.fill(copia, 0);
        System.out.println(Arrays.toString(copia));  // [0, 0, 0]

        // equals — confronto elemento per elemento (NON usare ==)
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        System.out.println(Arrays.equals(a, b));  // true

        // toString / deepToString — stampa leggibile
        System.out.println(Arrays.toString(a));          // [1, 2, 3]
        System.out.println(Arrays.deepToString(matrice)); // [[1,2,3],[4,5,6],[7,8,9]]

        // stream — converte in IntStream / Stream<T>
        int sum = Arrays.stream(a).sum();
        System.out.println(sum);  // 6


        // ── F. BOXING / UNBOXING ──────────────────────────────
        // int[] e Integer[] NON sono intercambiabili direttamente
        int[]     primitivo  = {1, 2, 3};
        Integer[] boxed      = {1, 2, 3};
        // Arrays.asList funziona su Integer[] ma NON su int[] come ci si aspetta
        System.out.println(Arrays.asList(boxed));      // [1, 2, 3]  ← corretto
        // Arrays.asList(primitivo) → List<int[]> con un solo elemento!

        // Per convertire int[] → List<Integer> usa lo stream:
        java.util.List<Integer> listaBoxed = Arrays.stream(primitivo)
            .boxed()
            .collect(java.util.stream.Collectors.toList());
        System.out.println(listaBoxed);  // [1, 2, 3]
    }
}

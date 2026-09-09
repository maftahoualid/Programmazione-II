package es25.pkg5;

import java.util.List;
import java.util.ArrayList;

class Nonno {}
class Padre extends Nonno {}
class Figlio extends Padre {}

public class TestLower {

    // METODO CON LOWER BOUND (super)
    // Accetta una lista che contiene tipi 'Padre' o una sua SUPERCLASSE (es. Nonno, Object)
    public static void aggiungiPadre(List<? super Padre> lista) {
        lista.add(new Padre());  // ✅ SICURO: Si può sempre inserire un 'Padre' o un 'Figlio'
        lista.add(new Figlio()); // ✅ SICURO: Figlio è un Padre
        
        // Padre p = lista.get(0); 
        // ❌ ERRORE IN LETTURA: Il compilatore non sa se la lista è di 'Nonno' o 'Object',
        // quindi in lettura restituisce solo un 'Object'.
    }

    public static void main(String[] args) {
        System.out.println("=== es25.pkg5: TestLower (Lower Bound con super) ===");
        List<Padre> listaPadri = new ArrayList<>();
        List<Nonno> listaNonni = new ArrayList<>();
        List<Figlio> listaFigli = new ArrayList<>();

        aggiungiPadre(listaPadri); // ✅ OK: Padre è la classe base
        aggiungiPadre(listaNonni); // ✅ OK: Nonno è superclasse di Padre

        System.out.println("listaPadri size: " + listaPadri.size());
        System.out.println("listaNonni size: " + listaNonni.size());

        // aggiungiPadre(listaFigli); 
        // ❌ ERRORE: Figlio è una SOTTOCLASSE di Padre, non una superclasse!
    }
}

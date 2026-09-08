package es14.it.univr.pkg2;

import es14.it.pkg1.*; // importerà pkg1_Class1 e pkg1_Class2 ma non subpkg1_Class1
import es14.it.pkg1.subpkg1.subpkg1_Class2;

public class ImportPacchetti {
    public static void main(String[] args) {
        pkg1_Class1.print("Ciao");
        pkg1_Class2.print("Ciao");
        // subpkg1_Class1.print("Ciao"); // errore: classe non visibile
        subpkg1_Class2.print("Ciao");
    }
}

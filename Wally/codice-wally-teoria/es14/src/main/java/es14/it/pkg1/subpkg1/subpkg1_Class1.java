package es14.it.pkg1.subpkg1; // sotto-package di pkg1

// non verrà importato da import es14.it.pkg1.*

public class subpkg1_Class1 {
    public static void print(String s) { // senza modificatori : visibilità solo dentro lo stesso package
        System.out.println(s);
    }
}

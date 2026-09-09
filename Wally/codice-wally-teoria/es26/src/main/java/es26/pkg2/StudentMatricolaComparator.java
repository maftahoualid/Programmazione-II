package es26.pkg2;

import java.util.Comparator;

/**
 * MODO 1: Classe Dedicata (Dedicated Class)
 *
 * Implementa Comparator<Student> per ordinare gli studenti in base alla matricola
 * in ordine crescente (senza modificare la classe Student).
 */
public class StudentMatricolaComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getMatricola(), s2.getMatricola());
    }
}

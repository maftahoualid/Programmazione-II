package es26.pkg4;

import java.util.Comparator;

/**
 * MODO 1: Classe Dedicata per Comparator<Student>
 *
 * Confronta due studenti in base alla matricola in ordine crescente.
 */
public class StudentMatricolaComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getMatricola(), s2.getMatricola());
    }
}

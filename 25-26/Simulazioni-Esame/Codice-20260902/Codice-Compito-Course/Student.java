package it.univr.course;

import java.util.Scanner;

/**
 * Uno studente, che si può iscrivere agli esami di un corso di laurea.
 * Implementa l'interfaccia {@link java.lang.Comparable}.
 */
public class Student implements Comparable<Student> {
	
	/**
	 * Crea uno studente con nome, cognome, matricola e anno di immatricolazione indicati.
	 * 
	 * @param name il nome dello studente.
	 * @param surname il cognome dello studente.
	 * @param matricola la matricola dello studente.
	 * @param enrolmentYear l'anno di immatricolazione dello studente.
	 *
	 * @throws IllegalStudentException se l'anno di immatricolazione è nel futuro o se la matricola è negativa.
	 */
	public Student(String name, String surname, int matricola, int enrolmentYear) throws IllegalStudentException {
		// TODO
	}

	/**
	 * Legge da tastiera i dati di uno studente, lo crea e lo restituisce. [da non modificare]
	 * 
	 * @param keyboard lo scanner associato allo standard input.
	 *
	 * @throws IllegalStudentException se i dati letti non sono validi
	 * @return il nuovo studente creato
	 */
	public static Student readFromKeyboard(Scanner keyboard) throws IllegalStudentException {
		System.out.print("Nome: ");
		String name = keyboard.nextLine();
		System.out.print("Cognome: ");
		String surname = keyboard.nextLine();
		System.out.print("Matricola: ");
		int matricola = keyboard.nextInt();
		keyboard.nextLine();
		System.out.print("Anno di immatricolazione: ");
		int enrolmentYear = keyboard.nextInt();
		keyboard.nextLine();

		return new Student(name, surname, matricola, enrolmentYear);
	}

	/**
	 * Due studenti sono uguali se e solo se hanno la stessa matricola.
	 */
	@Override
	public boolean equals(Object other) {
		// TODO
	}

	/**
	 * Restituisce una stringa del tipo "34555 Giulio Andreotti immatricolato nel 2017"
	 */
	@Override
	public String toString() {
		// TODO
	}

	/**
	 * Determina se questo studente è fuori corso rispetto al corso di laurea indicato,
	 *  ovvero se si è immatricolato prima della durata del corso di laurea.
	 *
	 * @param course corso di laurea per il quale si vuol fare il controllo.
	 *
	 * @return {@code true} se lo studente è fuori corso e {@code false} altrimenti.
	 */
	public boolean outOfTerm(Course course) {
		// TODO
	}
	
	// TODO: aggiungere i metodi accessori per la matricola e l'anno d'iscrizione
}

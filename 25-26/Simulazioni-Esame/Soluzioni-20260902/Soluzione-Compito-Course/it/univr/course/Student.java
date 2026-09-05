package it.univr.course;

import java.util.Scanner;
import java.time.Year;

/**
 * Uno studente, che si può iscrivere agli esami di un corso di laurea.
 * Implementa l'interfaccia {@link java.lang.Comparable}.
 */
public class Student implements Comparable<Student> {

	/**
	 * Nome dello studente.
	 */
	private final String name;
	
	/**
	 * Cognome dello studente.
	 */
	private final String surname;
	
	/**
	 * Numero di matricola dello studente.
	 */
	private final int matricola;
	
	/**
	 * Anno di immatricolazione dello studente.
	 */
	private final int enrolmentYear;
	
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
		this.name = name;
		this.surname = surname;
		if (matricola < 0) throw new IllegalStudentException("--> Matricola non valida!");
		this.matricola = matricola;
		if (Year.now().getValue() < enrolmentYear) throw new IllegalStudentException("--> Anno di immatricolazione non valido!");
		this.enrolmentYear = enrolmentYear;
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
		if (other == null) return false;
		if (this == other) return true;
		if (!(other instanceof Student)) return false;
		Student otherAsStudent = (Student) other;
		
		return matricola == otherAsStudent.getMatricola();
	}

	/**
	 * Deve essere non banale e compatibile con il metodo {@code equals}.
	 */
	@Override
	public int hashCode() {
		return matricola;
	}

	/**
	 * Determina l'ordinamento tra studenti per matricola.
	 * Uno studente con matricola più bassa è minore di uno studente con matricola più alta.
	 */
	@Override
	public int compareTo(Student other) {
		return matricola - other.getMatricola();
	}

	/**
	 * Restituisce una stringa del tipo "34555 Giulio Andreotti immatricolato nel 2017"
	 */
	@Override
	public String toString() {
		return String.format("%d %s %s immatricolato nel %d", matricola, name, surname, enrolmentYear);
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
		return (Year.now().getValue() - enrolmentYear) > course.getDuration();
	}
	
	/**
	 * Metodo accessore per la matricola dello studente.
	 *
	 * @return il numero di matricola.
	 */
	public int getMatricola() {
		return matricola;
	}
	
	/**
	 * Metodo accessore per l'anno d'iscrizione dello studente.
	 *
	 * @return l'anno di iscrizione.
	 */
	public int getEnrolmentYear() {
		return enrolmentYear;
	}
}

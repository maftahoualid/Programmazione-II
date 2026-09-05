package it.univr.course;

import java.time.Year;

/**
 * Uno studente lavoratore è identico a uno studente ma è considerato fuori corso
 *  nel doppio di anni rispetto a uno studente non lavoratore.
 * La classe estende {@link it.univr.course.Student}.
 */
public class WorkingStudent extends Student {

	/**
	 * Crea uno studente lavoratore con nome, cognome, matricola e anno di immatricolazione indicati.
	 * 
	 * @param name il nome dello studente.
	 * @param surname il cognome dello studente.
	 * @param matricola la matricola dello studente.
	 * @param enrolmentYear l'anno di immatricolazione dello studente.
	 *
	 * @throws IllegalStudentException se l'anno di immatricolazione è nel futuro o se la matricola è negativa.
	 */
	public WorkingStudent(String name, String surname, int matricola, int enrolmentYear) throws IllegalStudentException {
		super(name, surname, matricola, enrolmentYear);
	}

	/**
	 * Determina se questo studente lavoratore è fuori corso rispetto al corso di laurea indicato,
	 *  ovvero se si è immatricolato prima del doppio della durata del corso di laurea.
	 *
	 * @param course corso di laurea per il quale si vuol fare il controllo.
	 *
	 * @return {@code true} se lo studente è fuori corso e {@code false} altrimenti.
	 */
	@Override
	public boolean outOfTerm(Course course) {
		return (Year.now().getValue() - getEnrolmentYear()) > (course.getDuration() * 2);
	}
}

package it.univr.course;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Un esame di un corso di laurea, con il nome dell'esame e il corso di laurea a cui appartiene.
 */
public class Exam {
		
	/**
	 * Crea un esame con il nome indicato per il corso indicato, inizialmente senza iscritti.
	 *
	 * @param name il nome dell'esame.
	 * @param course il corso di laurea a cui appartiene l'esame.
	 */
	public Exam(String name, Course course) {
		// TODO
	}

	/**
	 * Iscrive lo studente indicato a questo esame.
	 * 
	 * @param student lo studente da iscrivere all'esame.
	 *
	 * @throws IllegalStudentException se ci fosse già uno studente iscritto a questo esame con la stessa matricola.
	 */
	public void enroll(Student student) throws IllegalStudentException {
		// TODO
	}

	/**
	 * Restituisce la stringa ottenuta concatenando tutti gli iscritti all'esame, in ordine crescente per matricola.
	 * All'inizio riporta il nome dell'esame e del corso, poi la lista di studenti (uno per riga).
	 */
	@Override
	public String toString() {
		// TODO
	}

	/**
	 * Esegue l'azione indicata per ogni studente iscritto che soddisfa la condizione indicata.
	 *
	 * @param condition la condizione da applicare agli studenti.
	 * @param action l'azione da eseguire sugli studenti.
	 */
	public void forEachEnrolledStudent(Predicate<Student> condition, Consumer<Student> action) {
		// TODO
	}
}

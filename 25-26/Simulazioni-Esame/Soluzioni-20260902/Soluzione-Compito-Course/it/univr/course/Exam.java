package it.univr.course;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.List;
import java.util.ArrayList;
import static java.util.Collections.sort;

/**
 * Un esame di un corso di laurea, con il nome dell'esame e il corso di laurea a cui appartiene.
 */
public class Exam {
	
	/**
	 * Nome dell'esame.
	 */
	private final String name;
	
	/**
	 * Corso di laurea a cui appartiene l'esame.
	 */
	private final Course course;
	
	/**
	 * Lista degli studenti iscritti all'esame.
	 */
	private final List<Student> students;
	
	/**
	 * Crea un esame con il nome indicato per il corso indicato, inizialmente senza iscritti.
	 *
	 * @param name il nome dell'esame.
	 * @param course il corso di laurea a cui appartiene l'esame.
	 */
	public Exam(String name, Course course) {
		this.name = name;
		if (course == null) throw new IllegalArgumentException("--> Corso non valido!");
		this.course = course;
		students = new ArrayList<>();
	}

	/**
	 * Iscrive lo studente indicato a questo esame.
	 * 
	 * @param student lo studente da iscrivere all'esame.
	 *
	 * @throws IllegalStudentException se ci fosse già uno studente iscritto a questo esame con la stessa matricola.
	 */
	public void enroll(Student student) throws IllegalStudentException {
		if (students.contains(student)) throw new IllegalStudentException("--> Studente già iscritto all'esame!");
		students.add(student);
	}

	/**
	 * Restituisce la stringa ottenuta concatenando tutti gli iscritti all'esame, in ordine crescente per matricola.
	 * All'inizio riporta il nome dell'esame e del corso, poi la lista di studenti (uno per riga).
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Esame di ").append(name).append(" del corso di ").append(course.getName()).append(":\n");
		sort(students);
		for (Student student : students)
			sb.append(student).append("\n");
		
		return sb.toString();
	}

	/**
	 * Esegue l'azione indicata per ogni studente iscritto che soddisfa la condizione indicata.
	 *
	 * @param condition la condizione da applicare agli studenti.
	 * @param action l'azione da eseguire sugli studenti.
	 */
	public void forEachEnrolledStudent(Predicate<Student> condition, Consumer<Student> action) {
		students.stream()
			.filter(condition)
			.forEach(action);
	}
}

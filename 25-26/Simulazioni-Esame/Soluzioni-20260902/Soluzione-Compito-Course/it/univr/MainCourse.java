package it.univr;

import java.util.Scanner;
import it.univr.course.*;

public class MainCourse {

	public static void main(String[] args) throws IllegalStudentException {
		Course informatica = new Course("Informatica", 3);
		Exam exam = new Exam("Programmazione II", informatica);

		// iscrive cinque studenti all'esame
		exam.enroll(new Student("Stephen", "Strange", 111564, 2022));
		exam.enroll(new Student("Nick", "Fury", 178066, 2025));
		exam.enroll(new WorkingStudent("Wanda", "Maximoff", 98034, 2019));
		exam.enroll(new WorkingStudent("Charles", "Xavier", 34555, 2018));
		exam.enroll(new Student("Steve", "Rogers", 151535, 2021));

		// crea uno scanner connesso allo standard input (tastiera)
		// legge uno studente da tale scanner e lo iscrive all'esame
		// se si verifica una {@code IllegalStudentException}, allora ripete la lettura e il tentativo di iscrizione ad oltranza
		// per leggere uno studente da uno scanner esiste un metodo specifico nella classe {@code Student}
		try (Scanner keyboard = new Scanner(System.in)) {
			Student student = null;
			while (student == null) {
				try {
					student = Student.readFromKeyboard(keyboard);
				} catch (IllegalStudentException sie) {
					System.out.println(sie.getMessage());
				}
			}
			exam.enroll(student); // delega al chiamante del main la gestione dell'eccezione
		}

		// stampa a video l'esame con tutti gli studenti iscritti
		System.out.println("\n" + exam);

		// chiama {@code forEachEnrolledStudent} per stampare a video le matricole degli studenti fuori corso iscritti all'esame
		System.out.println("Matricole degli studenti fuori corso:");		
		exam.forEachEnrolledStudent(
			s -> s.outOfTerm(informatica),
			s -> System.out.println(s.getMatricola())
		);

		// chiama {@code forEachEnrolledStudent} per stampare a video gli studenti lavoratori iscritti all'esame
		System.out.println("\nStudenti lavoratori:");		
		exam.forEachEnrolledStudent(
			s -> s instanceof WorkingStudent,
			System.out::println
		);
	}
}

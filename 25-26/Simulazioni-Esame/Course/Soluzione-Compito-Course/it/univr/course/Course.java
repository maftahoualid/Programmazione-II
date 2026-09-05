package it.univr.course;

/**
 * Un corso di laurea, con nome e durata in anni.
 */
public class Course {
	
	/**
	 * Nome del corso di laurea.
	 */
	private final String name;
	
	/**
	 * Durata del corso di laurea.
	 */
	private final int duration;
	
	/**
	 * Crea un corso di laurea con il nome e la durata indicati.
	 *
	 * @param name il nome del corso.
	 * @param duration la durata del corso.
	 */
	public Course(String name, int duration) {
		this.name = name;
		this.duration = duration > 0 ? duration : 1;
	}

	/**
	 * Restituisce una stringa che riporta il nome del corso.
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Metodo accessore per il nome del corso di laurea.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Metodo accessore per la durata del corso di laurea.
	 */
	public int getDuration() {
		return duration;
	}
}

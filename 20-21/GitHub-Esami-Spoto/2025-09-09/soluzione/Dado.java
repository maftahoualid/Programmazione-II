package it.univr.dadi;

/**
 * Un dado ha un numero prefissato di facce e può essere lanciato.
 */
public interface Dado {

	/**
	 * Restituisce il numero di facce del dado.
	 */
	public int getFacce();

	/**
	 * Restituisce il risultato di un lancio del dado,
	 * che sara' un numero fra 1 (incluso) e getFacce() (incluso).
	 */
	public int lancio();
}

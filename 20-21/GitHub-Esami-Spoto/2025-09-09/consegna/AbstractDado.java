package it.univr.dadi;

import java.util.Random;

/**
 * Implementazione parziale di un dado. Si occupa di gestire
 * e salvare il suo numero di facce, passato al costruttore.
 */
public abstract class AbstractDado implements Dado {

	// vi sara' utile nelle sottoclassi
	protected final static Random random = new Random();

	// TODO: aggiungete campi se servono

	/**
	 * Costruisce un dado con un numero prefissato di facce.
	 * Lancia IllegalArgumentException se il numero di facce non e' positivo.
	 */
	protected AbstractDado(int facce) {
		// TODO: completate
	}

	@Override
	public final int getFacce() {
		// TODO: completate
	}

	// QUESTA CLASSE E' abstract PERCHE' IL METODO lancio() QUI NON E' ANCORA IMPLEMENTATO
}
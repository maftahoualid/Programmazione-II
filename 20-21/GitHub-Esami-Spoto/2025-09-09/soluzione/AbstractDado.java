package it.univr.dadi;

import java.util.Random;

/**
 * Implementazoine parziale di un dado. Si occupa di gestire
 * e salvare il suo numero di facce, passato al costruttore.
 */
public abstract class AbstractDado implements Dado {

	// vi sara' utile nelle sottoclassi
	protected final static Random random = new Random();

	/**
	 * Il numero di facce del dado.
	 */
	private final int facce;

	/**
	 * Costruisce un dado con un numero prefissato di facce.
	 * Lancia IllegalArgumentException se il numero di facce non e' positivo.
	 */
	protected AbstractDado(int facce) {
		if (facce <= 0)
			throw new IllegalArgumentException("Un dado deve avere almeno una faccia");

		this.facce = facce;
	}

	@Override
	public final int getFacce() {
		return facce;
	}
}
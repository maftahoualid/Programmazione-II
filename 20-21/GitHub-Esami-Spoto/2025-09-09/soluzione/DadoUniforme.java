package it.univr.dadi;

/**
 * Un dado uniforme, in cui cioe' la probabilita' di ottenere una faccia,
 * lanciandolo, e' la stessa per ciascuna faccia.
 */
public abstract class DadoUniforme extends AbstractDado {

	/**
	 * Costruisce un dado con un numero prefissato di facce.
	 * Lancia IllegalArgumentException se il numero di facce non e' positivo.
	 */
	protected DadoUniforme(int facce) {
		super(facce);
	}

	@Override
	public final int lancio() {
		return random.nextInt(getFacce()) + 1;
	}
}
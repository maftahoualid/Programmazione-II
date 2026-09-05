package it.univr.election;

/**
 * Un partito politico, con un nome.
 */
public class Party implements Comparable<Party> {
	
	/**
	 * Crea un partito politco con il nome indicato.
	 *
	 * @param name il nome del partito.
	 */
	public Party(String name) {
		// TODO
	}

	/**
	 * Determina l'ordinamento tra partiti per nome.
	 * Un partito con nome alfabeticamente più basso è minore di un partito con nome alfabeticamente più alto.
	 */
	@Override
	public int compareTo(Party other) {
		// TODO
	}

	/**
	 * Due partiti sono uguali se e solo se hanno nome uguale.
	 */
	@Override
	public boolean equals(Object other) {
		// TODO
	}

	/**
	 * Deve essere non banale e compatibile con il metodo {@code equals}.
	 */
	@Override
	public int hashCode() {
		// TODO
	}

	/**
	 * Restituisce il nome del partito.
	 */
	@Override
	public String toString() {
		// TODO
	}
}

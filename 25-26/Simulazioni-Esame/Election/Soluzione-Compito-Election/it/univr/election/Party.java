package it.univr.election;

/**
 * Un partito politico, con un nome.
 */
public class Party implements Comparable<Party> {

	/**
	 * Nome del partito politico.
	 */
	private final String name;
	
	/**
	 * Crea un partito politco con il nome indicato.
	 *
	 * @param name il nome del partito.
	 */
	public Party(String name) {
		this.name = name;
	}

	/**
	 * Determina l'ordinamento tra partiti per nome.
	 * Un partito con nome alfabeticamente più basso è minore di un partito con nome alfabeticamente più alto.
	 */
	@Override
	public int compareTo(Party other) {
		return name.compareTo(other.toString());
	}

	/**
	 * Due partiti sono uguali se e solo se hanno nome uguale.
	 */
	@Override
	public boolean equals(Object other) {
		if (other == null) return false;
		if (this == other) return true;
		if (!(other instanceof Party)) return false;
		Party otherAsParty = (Party) other;
		return name.equals(otherAsParty.toString());
	}

	/**
	 * Deve essere non banale e compatibile con il metodo {@code equals}.
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * Restituisce il nome del partito.
	 */
	@Override
	public String toString() {
		return name;
	}
}

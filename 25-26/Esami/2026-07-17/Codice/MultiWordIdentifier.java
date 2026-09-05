package it.univr.plid;

/**
 * Classe che modella un identificatore composto da parole multiple (multiword).
 *
 * La classe implementa l'interfaccia {@link it.univr.plid.Identifier}.
 */
class MultiWordIdentifier { // TODO

  /**
   * L'elenco di parole che compongono l'identificatore.
   */
	protected final String[] words;
	
	/**
	 * Crea un identificatore multiword, a partire da un elenco di parole.
	 *
	 * @param words le parole componenti l'identificatore.
	 * @throw IllegalArgumentException quando nessuna paola viene fornita, 
	 *                                 quando viene fornita almeno una parola pari a {@code null} o alla stringa vuota, o
	 *                                 quando viene fornita almeno una parola contenente caratteri non alfabetici.
	 */
	protected MultiWordIdentifier(String... words) throws IllegalArgumentException {
		// TODO
	}

  /**
   * Restituisce una stringa che rappresenta l'identificatore.
   * Questo metodo richiama il metodo {@code toString(int pos, String word)} per ogni parola componente e concatenare le stringhe risultanti.
   */
	public final String toString() {
		// TODO
	}

	/**
	 * Restituisce la stringa che descrive la codifica (e.g., snake-style, three-style) della componente {@code pos}-esima dell'identificatore.
	 *
	 * @param la posizione della parola nell'identificatore (maggiore o uguale a 0).
	 * @param word la parola da codificare.
	 * @return la parola codificata.
	 */
	protected abstract String toString(int pos, String word);

}

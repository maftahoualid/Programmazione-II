package it.univr.plid;

/**
 * Classe che modella un identificatore composto da parole multiple (multiword).
 *
 * La classe implementa l'interfaccia {@link it.univr.plid.Identifier}.
 */
public abstract class MultiWordIdentifier implements Identifier {

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
		if (words.length == 0)
			throw new IllegalArgumentException("A multiword identifier needs at least one word.");

		for (String word: words) {
			if (word == null || word.isEmpty())
				throw new IllegalArgumentException("A word cannot be null or empty.");
			if (!isAlphabetic(word))
				throw new IllegalArgumentException("The word '" + word + "' is not alphabetic.");
    }
    
		this.words = words;
	}

  /**
   * Restituisce una stringa che rappresenta l'identificatore.
   * Questo metodo richiama il metodo {@code toString(int pos, String word)} per ogni parola componente e concatenare le stringhe risultanti.
   */
	@Override
	public final String toString() {
		String result = "";
		for (int pos = 0; pos < words.length; pos++)
			result += toString(pos, words[pos]);
	
		return result;
	}

	/**
	 * Restituisce la stringa che descrive la codifica (e.g., snake-style, three-style) della componente {@code pos}-esima dell'identificatore.
	 *
	 * @param la posizione della parola nell'identificatore (maggiore o uguale a 0).
	 * @param word la parola da codificare.
	 * @return la parola codificata.
	 */
	protected abstract String toString(int pos, String word);

  /**
   * Controlla se la parola contiene solo caratteri alfabetici.
   *
   * @param word la parola da controllare.
   * @return {@code true} se la parola contiene solo caratteri alfabetici, {@code false} altrimenti.
   */
	private static boolean isAlphabetic(String word) {
		return word.chars().allMatch(Character::isAlphabetic);
	}
	
}

package it.univr.plid;

/**
 * Classe che modella un identificatore composto da parole multiple (multiword) codificate in snake-style.
 *
 * La classe estende {@link it.univr.plid.MultiWordIdentifier}.
 */
public class SnakeStyleIdentifier extends MultiWordIdentifier {

	/**
	 * Crea un identificatore multiword in snake-style, a partire da un elenco di parole.
	 *
	 * @param words le parole componenti l'identificatore.
	 * @throw IllegalArgumentException quando nessuna paola viene fornita, 
	 *                                 quando viene fornita almeno una parola pari a {@code null} o alla stringa vuota, o
	 *                                 quando viene fornita almeno una parola contenente caratteri non alfabetici.
	 */
	public SnakeStyleIdentifier(String... words) throws IllegalArgumentException {
		// TODO
	}
	
	/**
	 * Crea un identificatore multiword in snake-style, a partire da un iterabile di parole.
	 *
	 * @param words le parole componenti l'identificatore.
	 * @throw IllegalArgumentException quando nessuna paola viene fornita, 
	 *                                 quando viene fornita almeno una parola pari a {@code null} o alla stringa vuota, o
	 *                                 quando viene fornita almeno una parola contenente caratteri non alfabetici.
	 */
	public SnakeStyleIdentifier(Iterable<String> words) throws IllegalArgumentException {
		// TODO
	}

  /**
	 * Restituisce la stringa che descrive la codifica snake-style della componente {@code pos}-esima dell'identificatore.
	 *
	 * @param la posizione della parola nell'identificatore (maggiore o uguale a 0).
	 * @param word la parola da codificare.
	 * @return la parola codificata.
	 */
	protected String toString(int pos, String word) {
		// TODO
	}
	
	/**
	 * Restituisce un identificatore three-style con le stesse parole dell'identificatore corrente.
	 */
	public ThreeStyleIdentifier toThreeStyle() {
		// TODO
	}
	
}

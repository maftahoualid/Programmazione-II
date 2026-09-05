package it.univr.plid;

import java.util.ArrayList;
import java.util.List;

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
		super(words);
	}
	
	/**
	 * Crea un identificatore multiword in snake-style, a partire da un iteratore di parole.
	 *
	 * @param words le parole componenti l'identificatore.
	 * @throw IllegalArgumentException quando nessuna paola viene fornita, 
	 *                                 quando viene fornita almeno una parola pari a {@code null} o alla stringa vuota, o
	 *                                 quando viene fornita almeno una parola contenente caratteri non alfabetici.
	 */
	public SnakeStyleIdentifier(Iterable<String> words) throws IllegalArgumentException {
		this(intoArray(words));
	}

  /**
	 * Restituisce la stringa che descrive la codifica snake-style della componente {@code pos}-esima dell'identificatore.
	 *
	 * @param la posizione della parola nell'identificatore (maggiore o uguale a 0).
	 * @param word la parola da codificare.
	 * @return la parola codificata.
	 */
	@Override
	protected String toString(int pos, String word) {
		return pos == 0 ? word : ("_" + word);
	}
	
	/**
	 * Restituisce un array di stringhe a partire da un iteratore di stringhe.
	 *
	 * @param words l'iteratore di stringhe.
	 * @return l'array di stringhe.
	 */
	private static String[] intoArray(Iterable<String> words) {
		List<String> list = new ArrayList<>();
		for (String word : words)
			list.add(word);

		return list.toArray(new String[list.size()]);
	}
	
	/**
	 * Restituisce un identificatore three-style con le stesse parole dell'identificatore corrente.
	 */
	public ThreeStyleIdentifier toThreeStyle() {
		return new ThreeStyleIdentifier(words);
	}
	
}

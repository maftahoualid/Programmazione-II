package it.univr.plid;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che modella un identificatore composto da parole multiple (multiword) codificate in three-style.
 *
 * La classe estende {@link it.univr.plid.MultiWordIdentifier}.
 */
public class ThreeStyleIdentifier extends MultiWordIdentifier {

	/**
	 * Crea un identificatore multiword in three-style, a partire da un elenco di parole.
	 *
	 * @param words le parole componenti l'identificatore.
	 * @throw IllegalArgumentException quando nessuna paola viene fornita, 
	 *                                 quando viene fornita almeno una parola pari a {@code null} o alla stringa vuota, o
	 *                                 quando viene fornita almeno una parola contenente caratteri non alfabetici.
	 */
	public ThreeStyleIdentifier(String... words) throws IllegalArgumentException {
		super(words);
	}

	/**
	 * Crea un identificatore multiword in three-style, a partire da un elenco di identificatori multiword.
	 * L'identificatore risultante corrisponde alla concatenazione delle parole degli identificatori.
	 *
	 * @param ids gli identificatori da concatenare.
	 * @throw IllegalArgumentException quando nessun identificatore viene fornito.
	 */
	public ThreeStyleIdentifier(MultiWordIdentifier... ids) throws IllegalArgumentException {
		this(intoArray(ids));
	}

  /**
	 * Restituisce la stringa che descrive la codifica three-style della componente {@code pos}-esima dell'identificatore.
	 *
	 * @param la posizione della parola nell'identificatore (maggiore o uguale a 0).
	 * @param word la parola da codificare.
	 * @return la parola codificata.
	 */
  @Override
	protected String toString(int pos, String word) {
		return word.substring(0, Math.min(3, word.length()));
	}
		
	/**
	 * Restituisce un array di stringhe a partire da un elenco di identificatori.
	 *
	 * @param words l'elenco di identificatori.
	 * @return l'array di stringhe.
	 */
	private static String[] intoArray(MultiWordIdentifier... ids) {
		List<String> list = new ArrayList<>();
		for (MultiWordIdentifier id : ids)
		  for (String word : id.words)
			  list.add(word);

		return list.toArray(new String[list.size()]);
	}
	
	/**
	 * Restituisce un identificatore snake-style con le stesse parole dell'identificatore corrente.
	 */
	public SnakeStyleIdentifier toSnakeStyle() {
		return new SnakeStyleIdentifier(words);
	}
	
}

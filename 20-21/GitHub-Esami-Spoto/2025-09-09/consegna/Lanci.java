package it.univr.dadi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Una classe che rappresenta l'esecuzione di piu' lanci con dei dadi.
 * Permette di stampare i risultati ottenuti e la frequenza dei numeri ottenuti,
 * come un istogramma.
 */
public class Lanci {

	// TODO: i seguenti tre campi sono sufficienti per risolvere l'esercizio,
	// ma potete comunque aggiungerne altri se volete

	/**
	 * Il minimo valore che si puo' ottenere lanciando i dadi forniti al costruttore.
	 */
	private final int min;

	/**
	 * Il massimo valore che si puo' ottenere lanciando i dadi forniti al costruttore.
	 */
	private final int max;

	/**
	 * Il risultato dei lanci effettuati nel costruttore.
	 */
	private final List<Integer> lanci = new ArrayList<>();

	/**
	 * Lancia i dadi indicati, insieme, "quanti" volte e salva
	 * le informazioni necessarie a implementare i metodi
	 * toString() e frequenze() della classe. Si noti il trucco di
	 * dichiarare almeno un primo dado, in modo da assicurarsi che venga
	 * fornito almeno un dado da lanciare.
	 * 
	 * @param quanti il numero di lanci da eseguire
	 * @param primoDado il primo dado da lanciare
	 * @param altriDadi gli altri dadi da lanciare, insieme al primo, "quanti" volte
	 * @throws IllegalArgumentException se "quanti" non e' positivo
	 */
	public Lanci(int quanti, Dado primoDado, Dado... altriDadi) {
		// TODO: lancia l'eccezione se serve
		
		// TODO: inizializza i tre campi dell'oggetto, eseguendo "quanti" lanci dei dadi, insieme
	}

	/**
	 * Restituisce la sequenza dei risultati ottenuti dal costruttore lanciando i dadi.
	 * Sara' una stringa fatta da una sequenza, fra parentesi quadre, di numeri separati da virgola.
	 * La lunghezza di questa frequenza e' il numero "quanti" passato al costruttore.
	 */
	@Override
	public final String toString() {
		// TODO: completate
	}

	/**
	 * Restituisce una rappresentazione a istogramma delle frequenze dei
	 * numeri ottenuti dal costruttore lanciando, insieme, i dadi. Le righe
	 * dell'istogramma sono della forma:
	 * 
	 * i: barra (F%)
	 * 
	 * Questo significa che la riga i-esima riporta la frequenza F con cui e' stato
	 * ottenuto "i", nel costruttore, lanciando insieme i dadi (cioe' in quanti casi
	 * e' stato ottenuto "i", in percentuale). La barra e' lunga in modo proporzionale
	 * ad F ed e' costruita tramite il metodo barra() che trovate sotto.
	 * Si vedano gli esempi nel testo del compito.
	 */
	public final String frequenze() {
		// TODO: completate
	}

	/**
	 * Restituisce una stringa lunga F caratteri (approssimato per difetto)
	 * che verra' usata per stampare la barra della riga i-esima dell'istogramma.
	 * In questa classe tale stringa sara' fatta da F asterischi (approssimato per difetto)
	 * e il numero della riga "i" e' irrilevante.
	 * Sottoclassi possono ridefinire queste scelte.
	 */
	protected String barra(int i, double F) {
		return "*".repeat((int) F);
	}
}

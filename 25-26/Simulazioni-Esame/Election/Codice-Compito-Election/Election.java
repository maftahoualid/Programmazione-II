package it.univr.election;

import java.util.Iterator;

/**
 * Un'elezione permette di registrare i voti ottenuti dai partiti politici.
 * Implementa l'interfaccia {@link java.lang.Iterable}.
 * Iterando su oggetti della classe si ottengono delle coppie partito e voti ottenuti,
 *  messe in ordine crescente per partito, appartenenti alla classe {@link it.univr.election.PartyVotes}.
 */
public class Election implements Iterable<PartyVotes> {
	
	/**
	 * Registra un voto per il partito indicato.
	 *
	 * @param party il partito a cui assegnare il voto.
	 */
	public final void vote(Party party) {
		// TODO
	}

	/**
	 * Ritorna una stringa che descrive l'elezione, del tipo:
	 *  1  Astenuti Anonimi:       850 voti (3.55%)
	 *  2  Estremismo Quieto:     5349 voti (22.32%)
	 *  3  I Sempre Ultimi:       8482 voti (35.39%)
	 *  4  Il Fronte del Divano:  7769 voti (32.42%)
	 *  5  Movimento 4 Gatti:     1515 voti (6.32%)
	 *
	 * I partiti sono riportati in ordine crescente, con a sinistra un indice crescente del partito (da 1 in su).
	 * Dopo il nome del partito viene riportato il numero dei voti ottenuti e la percentuale ottenuta fra tutti i voti espressi.
	 */
	@Override
	public String toString() {
		// TODO
	}

	/**
	 * Iterando su questo oggetto, si ottengono delle coppie partito e voti ottenuti,
	 * messe in ordine crescente per partito.
	 */
	@Override
	public final Iterator<PartyVotes> iterator() {
		// TODO
	}
}
